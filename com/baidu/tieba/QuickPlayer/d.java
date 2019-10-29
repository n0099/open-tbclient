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
    private static d ddx;
    private Set<b> ddB;
    private Set<b> ddC;
    private Set<b> ddD;
    private boolean ddE;
    private a ddF;
    private IQuickMediaPlayerService ddz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean ddy = false;
    private boolean ddA = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.ddy = true;
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(d.this.ddG);
            d.this.ddz = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.ddA) {
                d.this.ddA = false;
                d.this.aBY();
            }
            if (d.this.ddF != null) {
                d.this.ddF.a(d.this.ddz);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.ddy = false;
            d.this.ddA = true;
            com.baidu.adp.lib.g.e.fZ().postDelayed(d.this.ddG, 1000L);
        }
    };
    private Runnable ddG = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.ddy) {
                d.this.aBX();
                com.baidu.adp.lib.g.e.fZ().postDelayed(d.this.ddG, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aBZ();
    }

    private d() {
        aBX();
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.ddG, 1000L);
        this.ddB = new HashSet();
        this.ddC = new HashSet();
        this.ddD = new HashSet();
    }

    public static d aBW() {
        if (ddx == null) {
            synchronized (d.class) {
                if (ddx == null) {
                    ddx = new d();
                }
            }
        }
        return ddx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBX() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBY() {
        this.ddE = true;
        for (b bVar : this.ddB) {
            if (bVar != null) {
                bVar.aBZ();
            }
        }
        this.ddE = false;
        this.ddB.addAll(this.ddD);
        this.ddD.clear();
        this.ddB.removeAll(this.ddC);
        this.ddC.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.ddy && this.ddz != null) {
            try {
                return this.ddz.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.ddG, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.ddF = aVar;
    }

    public void a(b bVar) {
        if (this.ddE) {
            this.ddD.add(bVar);
        } else {
            this.ddB.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.ddE) {
            this.ddD.remove(bVar);
        } else {
            this.ddB.remove(bVar);
        }
    }
}
