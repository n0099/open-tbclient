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
    private static d bju;
    private Set<b> bjA;
    private boolean bjB;
    private a bjC;
    private IQuickMediaPlayerService bjw;
    private Set<b> bjy;
    private Set<b> bjz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bjv = false;
    private boolean bjx = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bjv = true;
            com.baidu.adp.lib.g.e.in().removeCallbacks(d.this.bjD);
            d.this.bjw = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bjx) {
                d.this.bjx = false;
                d.this.PD();
            }
            if (d.this.bjC != null) {
                d.this.bjC.a(d.this.bjw);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bjv = false;
            d.this.bjx = true;
            com.baidu.adp.lib.g.e.in().postDelayed(d.this.bjD, 1000L);
        }
    };
    private Runnable bjD = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bjv) {
                d.this.PC();
                com.baidu.adp.lib.g.e.in().postDelayed(d.this.bjD, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void PE();
    }

    private d() {
        PC();
        com.baidu.adp.lib.g.e.in().postDelayed(this.bjD, 1000L);
        this.bjy = new HashSet();
        this.bjz = new HashSet();
        this.bjA = new HashSet();
    }

    public static d PB() {
        if (bju == null) {
            synchronized (d.class) {
                if (bju == null) {
                    bju = new d();
                }
            }
        }
        return bju;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PC() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PD() {
        this.bjB = true;
        for (b bVar : this.bjy) {
            if (bVar != null) {
                bVar.PE();
            }
        }
        this.bjB = false;
        this.bjy.addAll(this.bjA);
        this.bjA.clear();
        this.bjy.removeAll(this.bjz);
        this.bjz.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bjv && this.bjw != null) {
            try {
                return this.bjw.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.in().postDelayed(this.bjD, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.bjC = aVar;
    }

    public void a(b bVar) {
        if (this.bjB) {
            this.bjA.add(bVar);
        } else {
            this.bjy.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bjB) {
            this.bjA.remove(bVar);
        } else {
            this.bjy.remove(bVar);
        }
    }
}
