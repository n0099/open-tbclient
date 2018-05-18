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
    private static d aZc;
    private IQuickMediaPlayerService aZe;
    private Set<b> aZg;
    private Set<b> aZh;
    private Set<b> aZi;
    private boolean aZj;
    private a aZk;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aZd = false;
    private boolean aZf = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aZd = true;
            com.baidu.adp.lib.g.e.fw().removeCallbacks(d.this.aZl);
            d.this.aZe = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aZf) {
                d.this.aZf = false;
                d.this.LB();
            }
            if (d.this.aZk != null) {
                d.this.aZk.a(d.this.aZe);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aZd = false;
            d.this.aZf = true;
            com.baidu.adp.lib.g.e.fw().postDelayed(d.this.aZl, 1000L);
        }
    };
    private Runnable aZl = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aZd) {
                d.this.LA();
                com.baidu.adp.lib.g.e.fw().postDelayed(d.this.aZl, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void LC();
    }

    private d() {
        LA();
        com.baidu.adp.lib.g.e.fw().postDelayed(this.aZl, 1000L);
        this.aZg = new HashSet();
        this.aZh = new HashSet();
        this.aZi = new HashSet();
    }

    public static d Lz() {
        if (aZc == null) {
            synchronized (d.class) {
                if (aZc == null) {
                    aZc = new d();
                }
            }
        }
        return aZc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LA() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LB() {
        this.aZj = true;
        for (b bVar : this.aZg) {
            if (bVar != null) {
                bVar.LC();
            }
        }
        this.aZj = false;
        this.aZg.addAll(this.aZi);
        this.aZi.clear();
        this.aZg.removeAll(this.aZh);
        this.aZh.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aZd && this.aZe != null) {
            try {
                return this.aZe.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.fw().postDelayed(this.aZl, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.aZk = aVar;
    }

    public void a(b bVar) {
        if (this.aZj) {
            this.aZi.add(bVar);
        } else {
            this.aZg.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.aZj) {
            this.aZi.remove(bVar);
        } else {
            this.aZg.remove(bVar);
        }
    }
}
