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
    private static d cTj;
    private IQuickMediaPlayerService cTl;
    private Set<b> cTn;
    private Set<b> cTo;
    private Set<b> cTp;
    private boolean cTq;
    private a cTr;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cTk = false;
    private boolean cTm = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cTk = true;
            com.baidu.adp.lib.g.e.iK().removeCallbacks(d.this.cTs);
            d.this.cTl = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cTm) {
                d.this.cTm = false;
                d.this.aBA();
            }
            if (d.this.cTr != null) {
                d.this.cTr.a(d.this.cTl);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cTk = false;
            d.this.cTm = true;
            com.baidu.adp.lib.g.e.iK().postDelayed(d.this.cTs, 1000L);
        }
    };
    private Runnable cTs = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cTk) {
                d.this.aBz();
                com.baidu.adp.lib.g.e.iK().postDelayed(d.this.cTs, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aBB();
    }

    private d() {
        aBz();
        com.baidu.adp.lib.g.e.iK().postDelayed(this.cTs, 1000L);
        this.cTn = new HashSet();
        this.cTo = new HashSet();
        this.cTp = new HashSet();
    }

    public static d aBy() {
        if (cTj == null) {
            synchronized (d.class) {
                if (cTj == null) {
                    cTj = new d();
                }
            }
        }
        return cTj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBz() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBA() {
        this.cTq = true;
        for (b bVar : this.cTn) {
            if (bVar != null) {
                bVar.aBB();
            }
        }
        this.cTq = false;
        this.cTn.addAll(this.cTp);
        this.cTp.clear();
        this.cTn.removeAll(this.cTo);
        this.cTo.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cTk && this.cTl != null) {
            try {
                return this.cTl.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.cTs, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cTr = aVar;
    }

    public void a(b bVar) {
        if (this.cTq) {
            this.cTp.add(bVar);
        } else {
            this.cTn.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cTq) {
            this.cTp.remove(bVar);
        } else {
            this.cTn.remove(bVar);
        }
    }
}
