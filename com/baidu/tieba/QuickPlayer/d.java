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
    private static d bPg;
    private IQuickMediaPlayerService bPi;
    private Set<b> bPk;
    private Set<b> bPl;
    private Set<b> bPm;
    private boolean bPn;
    private a bPo;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bPh = false;
    private boolean bPj = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bPh = true;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(d.this.bPp);
            d.this.bPi = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bPj) {
                d.this.bPj = false;
                d.this.Tg();
            }
            if (d.this.bPo != null) {
                d.this.bPo.a(d.this.bPi);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bPh = false;
            d.this.bPj = true;
            com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bPp, 1000L);
        }
    };
    private Runnable bPp = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bPh) {
                d.this.Tf();
                com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bPp, 1000L);
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
        this.bPk = new HashSet();
        this.bPl = new HashSet();
        this.bPm = new HashSet();
    }

    public static d Te() {
        if (bPg == null) {
            synchronized (d.class) {
                if (bPg == null) {
                    bPg = new d();
                }
            }
        }
        return bPg;
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
        this.bPn = true;
        for (b bVar : this.bPk) {
            if (bVar != null) {
                bVar.Th();
            }
        }
        this.bPn = false;
        this.bPk.addAll(this.bPm);
        this.bPm.clear();
        this.bPk.removeAll(this.bPl);
        this.bPl.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bPh && this.bPi != null) {
            try {
                return this.bPi.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        this.bPo = aVar;
    }

    public void a(b bVar) {
        if (this.bPn) {
            this.bPm.add(bVar);
        } else {
            this.bPk.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bPn) {
            this.bPm.remove(bVar);
        } else {
            this.bPk.remove(bVar);
        }
    }
}
