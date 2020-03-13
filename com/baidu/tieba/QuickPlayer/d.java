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
/* loaded from: classes13.dex */
public class d {
    private static d dVc;
    private IQuickMediaPlayerService dVe;
    private Set<b> dVg;
    private Set<b> dVh;
    private Set<b> dVi;
    private boolean dVj;
    private a dVk;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean dVd = false;
    private boolean dVf = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.dVd = true;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(d.this.dVl);
            d.this.dVe = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.dVf) {
                d.this.dVf = false;
                d.this.aWB();
            }
            if (d.this.dVk != null) {
                d.this.dVk.a(d.this.dVe);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.dVd = false;
            d.this.dVf = true;
            com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dVl, 1000L);
        }
    };
    private Runnable dVl = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.dVd) {
                d.this.aWA();
                com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dVl, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void aWC();
    }

    private d() {
        aWA();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dVl, 1000L);
        this.dVg = new HashSet();
        this.dVh = new HashSet();
        this.dVi = new HashSet();
    }

    public static d aWz() {
        if (dVc == null) {
            synchronized (d.class) {
                if (dVc == null) {
                    dVc = new d();
                }
            }
        }
        return dVc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWA() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWB() {
        this.dVj = true;
        for (b bVar : this.dVg) {
            if (bVar != null) {
                bVar.aWC();
            }
        }
        this.dVj = false;
        this.dVg.addAll(this.dVi);
        this.dVi.clear();
        this.dVg.removeAll(this.dVh);
        this.dVh.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.dVd && this.dVe != null) {
            try {
                return this.dVe.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dVl, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.dVk = aVar;
    }

    public void a(b bVar) {
        if (this.dVj) {
            this.dVi.add(bVar);
        } else {
            this.dVg.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.dVj) {
            this.dVi.remove(bVar);
        } else {
            this.dVg.remove(bVar);
        }
    }
}
