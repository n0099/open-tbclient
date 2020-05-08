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
    private static d evw;
    private Set<b> evA;
    private Set<b> evB;
    private Set<b> evC;
    private boolean evD;
    private a evE;
    private IQuickMediaPlayerService evy;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean evx = false;
    private boolean evz = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.evx = true;
            com.baidu.adp.lib.f.e.lb().removeCallbacks(d.this.evF);
            d.this.evy = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.evz) {
                d.this.evz = false;
                d.this.beJ();
            }
            if (d.this.evE != null) {
                d.this.evE.a(d.this.evy);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.evx = false;
            d.this.evz = true;
            com.baidu.adp.lib.f.e.lb().postDelayed(d.this.evF, 1000L);
        }
    };
    private Runnable evF = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.evx) {
                d.this.beI();
                com.baidu.adp.lib.f.e.lb().postDelayed(d.this.evF, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void beK();
    }

    private d() {
        beI();
        com.baidu.adp.lib.f.e.lb().postDelayed(this.evF, 1000L);
        this.evA = new HashSet();
        this.evB = new HashSet();
        this.evC = new HashSet();
    }

    public static d beH() {
        if (evw == null) {
            synchronized (d.class) {
                if (evw == null) {
                    evw = new d();
                }
            }
        }
        return evw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beI() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beJ() {
        this.evD = true;
        for (b bVar : this.evA) {
            if (bVar != null) {
                bVar.beK();
            }
        }
        this.evD = false;
        this.evA.addAll(this.evC);
        this.evC.clear();
        this.evA.removeAll(this.evB);
        this.evB.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.evx && this.evy != null) {
            try {
                return this.evy.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.evF, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.evE = aVar;
    }

    public void a(b bVar) {
        if (this.evD) {
            this.evC.add(bVar);
        } else {
            this.evA.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.evD) {
            this.evC.remove(bVar);
        } else {
            this.evA.remove(bVar);
        }
    }
}
