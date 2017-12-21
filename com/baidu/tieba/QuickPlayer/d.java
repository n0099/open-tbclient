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
    private static d aZh;
    private IQuickMediaPlayerService aZj;
    private Set<a> aZl;
    private Set<a> aZm;
    private Set<a> aZn;
    private boolean aZo;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aZi = false;
    private boolean aZk = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aZi = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aZp);
            d.this.aZj = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aZk) {
                d.this.aZk = false;
                d.this.Lk();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aZi = false;
            d.this.aZk = true;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aZp, 1000L);
        }
    };
    private Runnable aZp = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aZi) {
                d.this.Lj();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aZp, 1000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void Ll();
    }

    private d() {
        Lj();
        this.aZl = new HashSet();
        this.aZm = new HashSet();
        this.aZn = new HashSet();
    }

    public static d Li() {
        if (aZh == null) {
            synchronized (d.class) {
                if (aZh == null) {
                    aZh = new d();
                }
            }
        }
        return aZh;
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
        this.aZo = true;
        for (a aVar : this.aZl) {
            if (aVar != null) {
                aVar.Ll();
            }
        }
        this.aZo = false;
        this.aZl.addAll(this.aZn);
        this.aZn.clear();
        this.aZl.removeAll(this.aZm);
        this.aZm.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aZi && this.aZj != null) {
            try {
                return this.aZj.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        if (this.aZo) {
            this.aZn.add(aVar);
        } else {
            this.aZl.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.aZo) {
            this.aZn.remove(aVar);
        } else {
            this.aZl.remove(aVar);
        }
    }
}
