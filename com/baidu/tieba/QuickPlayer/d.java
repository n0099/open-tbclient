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
/* loaded from: classes3.dex */
public class d {
    private static d cTc;
    private IQuickMediaPlayerService cTe;
    private Set<b> cTg;
    private Set<b> cTh;
    private Set<b> cTi;
    private boolean cTj;
    private a cTk;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cTd = false;
    private boolean cTf = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cTd = true;
            com.baidu.adp.lib.g.e.iK().removeCallbacks(d.this.cTl);
            d.this.cTe = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cTf) {
                d.this.cTf = false;
                d.this.aBy();
            }
            if (d.this.cTk != null) {
                d.this.cTk.a(d.this.cTe);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cTd = false;
            d.this.cTf = true;
            com.baidu.adp.lib.g.e.iK().postDelayed(d.this.cTl, 1000L);
        }
    };
    private Runnable cTl = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cTd) {
                d.this.aBx();
                com.baidu.adp.lib.g.e.iK().postDelayed(d.this.cTl, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aBz();
    }

    private d() {
        aBx();
        com.baidu.adp.lib.g.e.iK().postDelayed(this.cTl, 1000L);
        this.cTg = new HashSet();
        this.cTh = new HashSet();
        this.cTi = new HashSet();
    }

    public static d aBw() {
        if (cTc == null) {
            synchronized (d.class) {
                if (cTc == null) {
                    cTc = new d();
                }
            }
        }
        return cTc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBx() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBy() {
        this.cTj = true;
        for (b bVar : this.cTg) {
            if (bVar != null) {
                bVar.aBz();
            }
        }
        this.cTj = false;
        this.cTg.addAll(this.cTi);
        this.cTi.clear();
        this.cTg.removeAll(this.cTh);
        this.cTh.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cTd && this.cTe != null) {
            try {
                return this.cTe.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.cTl, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cTk = aVar;
    }

    public void a(b bVar) {
        if (this.cTj) {
            this.cTi.add(bVar);
        } else {
            this.cTg.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cTj) {
            this.cTi.remove(bVar);
        } else {
            this.cTg.remove(bVar);
        }
    }
}
