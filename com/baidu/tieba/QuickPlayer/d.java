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
    private static d bPq;
    private IQuickMediaPlayerService bPs;
    private Set<b> bPu;
    private Set<b> bPv;
    private Set<b> bPw;
    private boolean bPx;
    private a bPy;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bPr = false;
    private boolean bPt = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bPr = true;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(d.this.bPz);
            d.this.bPs = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bPt) {
                d.this.bPt = false;
                d.this.Tg();
            }
            if (d.this.bPy != null) {
                d.this.bPy.a(d.this.bPs);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bPr = false;
            d.this.bPt = true;
            com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bPz, 1000L);
        }
    };
    private Runnable bPz = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bPr) {
                d.this.Tf();
                com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bPz, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Th();
    }

    private d() {
        Tf();
        this.bPu = new HashSet();
        this.bPv = new HashSet();
        this.bPw = new HashSet();
    }

    public static d Te() {
        if (bPq == null) {
            synchronized (d.class) {
                if (bPq == null) {
                    bPq = new d();
                }
            }
        }
        return bPq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tg() {
        this.bPx = true;
        for (b bVar : this.bPu) {
            if (bVar != null) {
                bVar.Th();
            }
        }
        this.bPx = false;
        this.bPu.addAll(this.bPw);
        this.bPw.clear();
        this.bPu.removeAll(this.bPv);
        this.bPv.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bPr && this.bPs != null) {
            try {
                return this.bPs.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        this.bPy = aVar;
    }

    public void a(b bVar) {
        if (this.bPx) {
            this.bPw.add(bVar);
        } else {
            this.bPu.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bPx) {
            this.bPw.remove(bVar);
        } else {
            this.bPu.remove(bVar);
        }
    }
}
