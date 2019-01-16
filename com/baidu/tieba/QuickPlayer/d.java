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
    private static d bym;
    private IQuickMediaPlayerService byo;
    private Set<b> byq;
    private Set<b> byr;
    private Set<b> bys;
    private boolean byt;
    private a byu;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean byn = false;
    private boolean byp = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.byn = true;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.byv);
            d.this.byo = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.byp) {
                d.this.byp = false;
                d.this.Vf();
            }
            if (d.this.byu != null) {
                d.this.byu.a(d.this.byo);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.byn = false;
            d.this.byp = true;
            com.baidu.adp.lib.g.e.jG().postDelayed(d.this.byv, 1000L);
        }
    };
    private Runnable byv = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.byn) {
                d.this.Ve();
                com.baidu.adp.lib.g.e.jG().postDelayed(d.this.byv, 1000L);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void Vg();
    }

    private d() {
        Ve();
        com.baidu.adp.lib.g.e.jG().postDelayed(this.byv, 1000L);
        this.byq = new HashSet();
        this.byr = new HashSet();
        this.bys = new HashSet();
    }

    public static d Vd() {
        if (bym == null) {
            synchronized (d.class) {
                if (bym == null) {
                    bym = new d();
                }
            }
        }
        return bym;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ve() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vf() {
        this.byt = true;
        for (b bVar : this.byq) {
            if (bVar != null) {
                bVar.Vg();
            }
        }
        this.byt = false;
        this.byq.addAll(this.bys);
        this.bys.clear();
        this.byq.removeAll(this.byr);
        this.byr.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.byn && this.byo != null) {
            try {
                return this.byo.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.byv, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.byu = aVar;
    }

    public void a(b bVar) {
        if (this.byt) {
            this.bys.add(bVar);
        } else {
            this.byq.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.byt) {
            this.bys.remove(bVar);
        } else {
            this.byq.remove(bVar);
        }
    }
}
