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
    private static d evr;
    private IQuickMediaPlayerService evt;
    private Set<b> evv;
    private Set<b> evw;
    private Set<b> evx;
    private boolean evy;
    private a evz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean evs = false;
    private boolean evu = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.evs = true;
            com.baidu.adp.lib.f.e.lb().removeCallbacks(d.this.evA);
            d.this.evt = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.evu) {
                d.this.evu = false;
                d.this.beL();
            }
            if (d.this.evz != null) {
                d.this.evz.a(d.this.evt);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.evs = false;
            d.this.evu = true;
            com.baidu.adp.lib.f.e.lb().postDelayed(d.this.evA, 1000L);
        }
    };
    private Runnable evA = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.evs) {
                d.this.beK();
                com.baidu.adp.lib.f.e.lb().postDelayed(d.this.evA, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void beM();
    }

    private d() {
        beK();
        com.baidu.adp.lib.f.e.lb().postDelayed(this.evA, 1000L);
        this.evv = new HashSet();
        this.evw = new HashSet();
        this.evx = new HashSet();
    }

    public static d beJ() {
        if (evr == null) {
            synchronized (d.class) {
                if (evr == null) {
                    evr = new d();
                }
            }
        }
        return evr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beK() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beL() {
        this.evy = true;
        for (b bVar : this.evv) {
            if (bVar != null) {
                bVar.beM();
            }
        }
        this.evy = false;
        this.evv.addAll(this.evx);
        this.evx.clear();
        this.evv.removeAll(this.evw);
        this.evw.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.evs && this.evt != null) {
            try {
                return this.evt.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.evA, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.evz = aVar;
    }

    public void a(b bVar) {
        if (this.evy) {
            this.evx.add(bVar);
        } else {
            this.evv.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.evy) {
            this.evx.remove(bVar);
        } else {
            this.evv.remove(bVar);
        }
    }
}
