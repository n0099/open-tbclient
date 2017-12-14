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
/* loaded from: classes.dex */
public class d {
    private static d aZd;
    private IQuickMediaPlayerService aZf;
    private Set<a> aZh;
    private Set<a> aZi;
    private Set<a> aZj;
    private boolean aZk;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aZe = false;
    private boolean aZg = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aZe = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aZl);
            d.this.aZf = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aZg) {
                d.this.aZg = false;
                d.this.Lk();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aZe = false;
            d.this.aZg = true;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aZl, 1000L);
        }
    };
    private Runnable aZl = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aZe) {
                d.this.Lj();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aZl, 1000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void Ll();
    }

    private d() {
        Lj();
        this.aZh = new HashSet();
        this.aZi = new HashSet();
        this.aZj = new HashSet();
    }

    public static d Li() {
        if (aZd == null) {
            synchronized (d.class) {
                if (aZd == null) {
                    aZd = new d();
                }
            }
        }
        return aZd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        this.aZk = true;
        for (a aVar : this.aZh) {
            if (aVar != null) {
                aVar.Ll();
            }
        }
        this.aZk = false;
        this.aZh.addAll(this.aZj);
        this.aZj.clear();
        this.aZh.removeAll(this.aZi);
        this.aZi.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aZe && this.aZf != null) {
            try {
                return this.aZf.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        if (this.aZk) {
            this.aZj.add(aVar);
        } else {
            this.aZh.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.aZk) {
            this.aZj.remove(aVar);
        } else {
            this.aZh.remove(aVar);
        }
    }
}
