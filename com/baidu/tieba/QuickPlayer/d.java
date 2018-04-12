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
    private static d aZb;
    private IQuickMediaPlayerService aZd;
    private Set<b> aZf;
    private Set<b> aZg;
    private Set<b> aZh;
    private boolean aZi;
    private a aZj;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aZc = false;
    private boolean aZe = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aZc = true;
            com.baidu.adp.lib.g.e.fw().removeCallbacks(d.this.aZk);
            d.this.aZd = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aZe) {
                d.this.aZe = false;
                d.this.LD();
            }
            if (d.this.aZj != null) {
                d.this.aZj.a(d.this.aZd);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aZc = false;
            d.this.aZe = true;
            com.baidu.adp.lib.g.e.fw().postDelayed(d.this.aZk, 1000L);
        }
    };
    private Runnable aZk = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aZc) {
                d.this.LC();
                com.baidu.adp.lib.g.e.fw().postDelayed(d.this.aZk, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void LE();
    }

    private d() {
        LC();
        com.baidu.adp.lib.g.e.fw().postDelayed(this.aZk, 1000L);
        this.aZf = new HashSet();
        this.aZg = new HashSet();
        this.aZh = new HashSet();
    }

    public static d LB() {
        if (aZb == null) {
            synchronized (d.class) {
                if (aZb == null) {
                    aZb = new d();
                }
            }
        }
        return aZb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LC() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LD() {
        this.aZi = true;
        for (b bVar : this.aZf) {
            if (bVar != null) {
                bVar.LE();
            }
        }
        this.aZi = false;
        this.aZf.addAll(this.aZh);
        this.aZh.clear();
        this.aZf.removeAll(this.aZg);
        this.aZg.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aZc && this.aZd != null) {
            try {
                return this.aZd.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.fw().postDelayed(this.aZk, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.aZj = aVar;
    }

    public void a(b bVar) {
        if (this.aZi) {
            this.aZh.add(bVar);
        } else {
            this.aZf.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.aZi) {
            this.aZh.remove(bVar);
        } else {
            this.aZf.remove(bVar);
        }
    }
}
