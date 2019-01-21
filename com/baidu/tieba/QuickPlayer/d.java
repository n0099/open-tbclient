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
    private static d byn;
    private IQuickMediaPlayerService byp;
    private Set<b> byr;
    private Set<b> bys;
    private Set<b> byt;
    private boolean byu;
    private a byv;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean byo = false;
    private boolean byq = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.byo = true;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.byw);
            d.this.byp = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.byq) {
                d.this.byq = false;
                d.this.Vf();
            }
            if (d.this.byv != null) {
                d.this.byv.a(d.this.byp);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.byo = false;
            d.this.byq = true;
            com.baidu.adp.lib.g.e.jG().postDelayed(d.this.byw, 1000L);
        }
    };
    private Runnable byw = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.byo) {
                d.this.Ve();
                com.baidu.adp.lib.g.e.jG().postDelayed(d.this.byw, 1000L);
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
        com.baidu.adp.lib.g.e.jG().postDelayed(this.byw, 1000L);
        this.byr = new HashSet();
        this.bys = new HashSet();
        this.byt = new HashSet();
    }

    public static d Vd() {
        if (byn == null) {
            synchronized (d.class) {
                if (byn == null) {
                    byn = new d();
                }
            }
        }
        return byn;
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
        this.byu = true;
        for (b bVar : this.byr) {
            if (bVar != null) {
                bVar.Vg();
            }
        }
        this.byu = false;
        this.byr.addAll(this.byt);
        this.byt.clear();
        this.byr.removeAll(this.bys);
        this.bys.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.byo && this.byp != null) {
            try {
                return this.byp.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.byw, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.byv = aVar;
    }

    public void a(b bVar) {
        if (this.byu) {
            this.byt.add(bVar);
        } else {
            this.byr.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.byu) {
            this.byt.remove(bVar);
        } else {
            this.byr.remove(bVar);
        }
    }
}
