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
    private static d bNb;
    private IQuickMediaPlayerService bNd;
    private Set<a> bNf;
    private Set<a> bNg;
    private Set<a> bNh;
    private boolean bNi;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bNc = false;
    private boolean bNe = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bNc = true;
            com.baidu.adp.lib.g.e.nr().removeCallbacks(d.this.bNj);
            d.this.bNd = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bNe) {
                d.this.bNe = false;
                d.this.Sx();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bNc = false;
            d.this.bNe = true;
            com.baidu.adp.lib.g.e.nr().postDelayed(d.this.bNj, 1000L);
        }
    };
    private Runnable bNj = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bNc) {
                d.this.Sw();
                com.baidu.adp.lib.g.e.nr().postDelayed(d.this.bNj, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void Sy();
    }

    private d() {
        Sw();
        this.bNf = new HashSet();
        this.bNg = new HashSet();
        this.bNh = new HashSet();
    }

    public static d Sv() {
        if (bNb == null) {
            synchronized (d.class) {
                if (bNb == null) {
                    bNb = new d();
                }
            }
        }
        return bNb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sw() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sx() {
        this.bNi = true;
        for (a aVar : this.bNf) {
            if (aVar != null) {
                aVar.Sy();
            }
        }
        this.bNi = false;
        this.bNf.addAll(this.bNh);
        this.bNh.clear();
        this.bNf.removeAll(this.bNg);
        this.bNg.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bNc && this.bNd != null) {
            try {
                return this.bNd.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        if (this.bNi) {
            this.bNh.add(aVar);
        } else {
            this.bNf.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.bNi) {
            this.bNh.remove(aVar);
        } else {
            this.bNf.remove(aVar);
        }
    }
}
