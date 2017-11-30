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
    private static d aZb;
    private IQuickMediaPlayerService aZd;
    private Set<a> aZf;
    private Set<a> aZg;
    private Set<a> aZh;
    private boolean aZi;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aZc = false;
    private boolean aZe = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aZc = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aZj);
            d.this.aZd = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aZe) {
                d.this.aZe = false;
                d.this.Lk();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aZc = false;
            d.this.aZe = true;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aZj, 1000L);
        }
    };
    private Runnable aZj = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aZc) {
                d.this.Lj();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aZj, 1000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void Ll();
    }

    private d() {
        Lj();
        this.aZf = new HashSet();
        this.aZg = new HashSet();
        this.aZh = new HashSet();
    }

    public static d Li() {
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
    public void Lj() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        this.aZi = true;
        for (a aVar : this.aZf) {
            if (aVar != null) {
                aVar.Ll();
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
        }
        return null;
    }

    public void a(a aVar) {
        if (this.aZi) {
            this.aZh.add(aVar);
        } else {
            this.aZf.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.aZi) {
            this.aZh.remove(aVar);
        } else {
            this.aZf.remove(aVar);
        }
    }
}
