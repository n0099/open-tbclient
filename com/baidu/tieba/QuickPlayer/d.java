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
    private static d bNj;
    private IQuickMediaPlayerService bNl;
    private Set<a> bNn;
    private Set<a> bNo;
    private Set<a> bNp;
    private boolean bNq;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bNk = false;
    private boolean bNm = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bNk = true;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(d.this.bNr);
            d.this.bNl = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bNm) {
                d.this.bNm = false;
                d.this.Sz();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bNk = false;
            d.this.bNm = true;
            com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bNr, 1000L);
        }
    };
    private Runnable bNr = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bNk) {
                d.this.Sy();
                com.baidu.adp.lib.g.e.ns().postDelayed(d.this.bNr, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void SA();
    }

    private d() {
        Sy();
        this.bNn = new HashSet();
        this.bNo = new HashSet();
        this.bNp = new HashSet();
    }

    public static d Sx() {
        if (bNj == null) {
            synchronized (d.class) {
                if (bNj == null) {
                    bNj = new d();
                }
            }
        }
        return bNj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sy() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sz() {
        this.bNq = true;
        for (a aVar : this.bNn) {
            if (aVar != null) {
                aVar.SA();
            }
        }
        this.bNq = false;
        this.bNn.addAll(this.bNp);
        this.bNp.clear();
        this.bNn.removeAll(this.bNo);
        this.bNo.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bNk && this.bNl != null) {
            try {
                return this.bNl.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        if (this.bNq) {
            this.bNp.add(aVar);
        } else {
            this.bNn.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.bNq) {
            this.bNp.remove(aVar);
        } else {
            this.bNn.remove(aVar);
        }
    }
}
