package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class d {
    private static d dQA;
    private IQuickMediaPlayerService dQC;
    private Set<b> dQE;
    private Set<b> dQF;
    private Set<b> dQG;
    private boolean dQH;
    private a dQI;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean dQB = false;
    private boolean dQD = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.dQB = true;
            com.baidu.adp.lib.f.e.gy().removeCallbacks(d.this.dQJ);
            d.this.dQC = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.dQD) {
                d.this.dQD = false;
                d.this.aTO();
            }
            if (d.this.dQI != null) {
                d.this.dQI.a(d.this.dQC);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.dQB = false;
            d.this.dQD = true;
            com.baidu.adp.lib.f.e.gy().postDelayed(d.this.dQJ, 1000L);
        }
    };
    private Runnable dQJ = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.dQB) {
                d.this.aTN();
                com.baidu.adp.lib.f.e.gy().postDelayed(d.this.dQJ, 1000L);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void aTP();
    }

    private d() {
        aTN();
        com.baidu.adp.lib.f.e.gy().postDelayed(this.dQJ, 1000L);
        this.dQE = new HashSet();
        this.dQF = new HashSet();
        this.dQG = new HashSet();
    }

    public static d aTM() {
        if (dQA == null) {
            synchronized (d.class) {
                if (dQA == null) {
                    dQA = new d();
                }
            }
        }
        return dQA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTN() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTO() {
        this.dQH = true;
        for (b bVar : this.dQE) {
            if (bVar != null) {
                bVar.aTP();
            }
        }
        this.dQH = false;
        this.dQE.addAll(this.dQG);
        this.dQG.clear();
        this.dQE.removeAll(this.dQF);
        this.dQF.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.dQB && this.dQC != null) {
            try {
                return this.dQC.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.dQJ, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.dQI = aVar;
    }

    public void a(b bVar) {
        if (this.dQH) {
            this.dQG.add(bVar);
        } else {
            this.dQE.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.dQH) {
            this.dQG.remove(bVar);
        } else {
            this.dQE.remove(bVar);
        }
    }
}
