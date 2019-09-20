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
    private static d cUc;
    private IQuickMediaPlayerService cUe;
    private Set<b> cUg;
    private Set<b> cUh;
    private Set<b> cUi;
    private boolean cUj;
    private a cUk;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cUd = false;
    private boolean cUf = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cUd = true;
            com.baidu.adp.lib.g.e.iK().removeCallbacks(d.this.cUl);
            d.this.cUe = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cUf) {
                d.this.cUf = false;
                d.this.aBO();
            }
            if (d.this.cUk != null) {
                d.this.cUk.a(d.this.cUe);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cUd = false;
            d.this.cUf = true;
            com.baidu.adp.lib.g.e.iK().postDelayed(d.this.cUl, 1000L);
        }
    };
    private Runnable cUl = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cUd) {
                d.this.aBN();
                com.baidu.adp.lib.g.e.iK().postDelayed(d.this.cUl, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aBP();
    }

    private d() {
        aBN();
        com.baidu.adp.lib.g.e.iK().postDelayed(this.cUl, 1000L);
        this.cUg = new HashSet();
        this.cUh = new HashSet();
        this.cUi = new HashSet();
    }

    public static d aBM() {
        if (cUc == null) {
            synchronized (d.class) {
                if (cUc == null) {
                    cUc = new d();
                }
            }
        }
        return cUc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBN() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBO() {
        this.cUj = true;
        for (b bVar : this.cUg) {
            if (bVar != null) {
                bVar.aBP();
            }
        }
        this.cUj = false;
        this.cUg.addAll(this.cUi);
        this.cUi.clear();
        this.cUg.removeAll(this.cUh);
        this.cUh.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cUd && this.cUe != null) {
            try {
                return this.cUe.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.cUl, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cUk = aVar;
    }

    public void a(b bVar) {
        if (this.cUj) {
            this.cUi.add(bVar);
        } else {
            this.cUg.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cUj) {
            this.cUi.remove(bVar);
        } else {
            this.cUg.remove(bVar);
        }
    }
}
