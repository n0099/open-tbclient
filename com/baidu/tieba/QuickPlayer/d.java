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
/* loaded from: classes2.dex */
public class d {
    private static d bjA;
    private IQuickMediaPlayerService bjC;
    private Set<b> bjE;
    private Set<b> bjF;
    private Set<b> bjG;
    private boolean bjH;
    private a bjI;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bjB = false;
    private boolean bjD = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bjB = true;
            com.baidu.adp.lib.g.e.in().removeCallbacks(d.this.bjJ);
            d.this.bjC = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bjD) {
                d.this.bjD = false;
                d.this.PJ();
            }
            if (d.this.bjI != null) {
                d.this.bjI.a(d.this.bjC);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bjB = false;
            d.this.bjD = true;
            com.baidu.adp.lib.g.e.in().postDelayed(d.this.bjJ, 1000L);
        }
    };
    private Runnable bjJ = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bjB) {
                d.this.PI();
                com.baidu.adp.lib.g.e.in().postDelayed(d.this.bjJ, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void PK();
    }

    private d() {
        PI();
        com.baidu.adp.lib.g.e.in().postDelayed(this.bjJ, 1000L);
        this.bjE = new HashSet();
        this.bjF = new HashSet();
        this.bjG = new HashSet();
    }

    public static d PH() {
        if (bjA == null) {
            synchronized (d.class) {
                if (bjA == null) {
                    bjA = new d();
                }
            }
        }
        return bjA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PI() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PJ() {
        this.bjH = true;
        for (b bVar : this.bjE) {
            if (bVar != null) {
                bVar.PK();
            }
        }
        this.bjH = false;
        this.bjE.addAll(this.bjG);
        this.bjG.clear();
        this.bjE.removeAll(this.bjF);
        this.bjF.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bjB && this.bjC != null) {
            try {
                return this.bjC.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.in().postDelayed(this.bjJ, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.bjI = aVar;
    }

    public void a(b bVar) {
        if (this.bjH) {
            this.bjG.add(bVar);
        } else {
            this.bjE.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bjH) {
            this.bjG.remove(bVar);
        } else {
            this.bjE.remove(bVar);
        }
    }
}
