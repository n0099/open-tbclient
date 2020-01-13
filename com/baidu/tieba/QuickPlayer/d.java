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
/* loaded from: classes11.dex */
public class d {
    private static d dQJ;
    private IQuickMediaPlayerService dQL;
    private Set<b> dQN;
    private Set<b> dQO;
    private Set<b> dQP;
    private boolean dQQ;
    private a dQR;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean dQK = false;
    private boolean dQM = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.dQK = true;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(d.this.dQS);
            d.this.dQL = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.dQM) {
                d.this.dQM = false;
                d.this.aUi();
            }
            if (d.this.dQR != null) {
                d.this.dQR.a(d.this.dQL);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.dQK = false;
            d.this.dQM = true;
            com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dQS, 1000L);
        }
    };
    private Runnable dQS = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.dQK) {
                d.this.aUh();
                com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dQS, 1000L);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void aUj();
    }

    private d() {
        aUh();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dQS, 1000L);
        this.dQN = new HashSet();
        this.dQO = new HashSet();
        this.dQP = new HashSet();
    }

    public static d aUg() {
        if (dQJ == null) {
            synchronized (d.class) {
                if (dQJ == null) {
                    dQJ = new d();
                }
            }
        }
        return dQJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUh() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUi() {
        this.dQQ = true;
        for (b bVar : this.dQN) {
            if (bVar != null) {
                bVar.aUj();
            }
        }
        this.dQQ = false;
        this.dQN.addAll(this.dQP);
        this.dQP.clear();
        this.dQN.removeAll(this.dQO);
        this.dQO.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.dQK && this.dQL != null) {
            try {
                return this.dQL.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dQS, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.dQR = aVar;
    }

    public void a(b bVar) {
        if (this.dQQ) {
            this.dQP.add(bVar);
        } else {
            this.dQN.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.dQQ) {
            this.dQP.remove(bVar);
        } else {
            this.dQN.remove(bVar);
        }
    }
}
