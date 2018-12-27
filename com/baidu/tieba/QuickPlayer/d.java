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
/* loaded from: classes5.dex */
public class d {
    private static d bxy;
    private IQuickMediaPlayerService bxA;
    private Set<b> bxC;
    private Set<b> bxD;
    private Set<b> bxE;
    private boolean bxF;
    private a bxG;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bxz = false;
    private boolean bxB = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bxz = true;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.bxH);
            d.this.bxA = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bxB) {
                d.this.bxB = false;
                d.this.UJ();
            }
            if (d.this.bxG != null) {
                d.this.bxG.a(d.this.bxA);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bxz = false;
            d.this.bxB = true;
            com.baidu.adp.lib.g.e.jG().postDelayed(d.this.bxH, 1000L);
        }
    };
    private Runnable bxH = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bxz) {
                d.this.UI();
                com.baidu.adp.lib.g.e.jG().postDelayed(d.this.bxH, 1000L);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void UK();
    }

    private d() {
        UI();
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bxH, 1000L);
        this.bxC = new HashSet();
        this.bxD = new HashSet();
        this.bxE = new HashSet();
    }

    public static d UH() {
        if (bxy == null) {
            synchronized (d.class) {
                if (bxy == null) {
                    bxy = new d();
                }
            }
        }
        return bxy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UI() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UJ() {
        this.bxF = true;
        for (b bVar : this.bxC) {
            if (bVar != null) {
                bVar.UK();
            }
        }
        this.bxF = false;
        this.bxC.addAll(this.bxE);
        this.bxE.clear();
        this.bxC.removeAll(this.bxD);
        this.bxD.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bxz && this.bxA != null) {
            try {
                return this.bxA.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.bxH, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.bxG = aVar;
    }

    public void a(b bVar) {
        if (this.bxF) {
            this.bxE.add(bVar);
        } else {
            this.bxC.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bxF) {
            this.bxE.remove(bVar);
        } else {
            this.bxC.remove(bVar);
        }
    }
}
