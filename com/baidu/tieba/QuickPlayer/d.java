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
    private static d bPd;
    private IQuickMediaPlayerService bPf;
    private Set<b> bPh;
    private Set<b> bPi;
    private Set<b> bPj;
    private boolean bPk;
    private a bPl;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bPe = false;
    private boolean bPg = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bPe = true;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(d.this.bPm);
            d.this.bPf = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bPg) {
                d.this.bPg = false;
                d.this.Tf();
            }
            if (d.this.bPl != null) {
                d.this.bPl.a(d.this.bPf);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bPe = false;
            d.this.bPg = true;
            com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bPm, 1000L);
        }
    };
    private Runnable bPm = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bPe) {
                d.this.Te();
                com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bPm, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Tg();
    }

    private d() {
        Te();
        this.bPh = new HashSet();
        this.bPi = new HashSet();
        this.bPj = new HashSet();
    }

    public static d Td() {
        if (bPd == null) {
            synchronized (d.class) {
                if (bPd == null) {
                    bPd = new d();
                }
            }
        }
        return bPd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Te() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        this.bPk = true;
        for (b bVar : this.bPh) {
            if (bVar != null) {
                bVar.Tg();
            }
        }
        this.bPk = false;
        this.bPh.addAll(this.bPj);
        this.bPj.clear();
        this.bPh.removeAll(this.bPi);
        this.bPi.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bPe && this.bPf != null) {
            try {
                return this.bPf.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        this.bPl = aVar;
    }

    public void a(b bVar) {
        if (this.bPk) {
            this.bPj.add(bVar);
        } else {
            this.bPh.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bPk) {
            this.bPj.remove(bVar);
        } else {
            this.bPh.remove(bVar);
        }
    }
}
