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
    private static d cJu;
    private Set<b> cJA;
    private boolean cJB;
    private a cJC;
    private IQuickMediaPlayerService cJw;
    private Set<b> cJy;
    private Set<b> cJz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cJv = false;
    private boolean cJx = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cJv = true;
            com.baidu.adp.lib.g.e.jH().removeCallbacks(d.this.cJD);
            d.this.cJw = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cJx) {
                d.this.cJx = false;
                d.this.avb();
            }
            if (d.this.cJC != null) {
                d.this.cJC.a(d.this.cJw);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cJv = false;
            d.this.cJx = true;
            com.baidu.adp.lib.g.e.jH().postDelayed(d.this.cJD, 1000L);
        }
    };
    private Runnable cJD = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cJv) {
                d.this.ava();
                com.baidu.adp.lib.g.e.jH().postDelayed(d.this.cJD, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void avc();
    }

    private d() {
        ava();
        com.baidu.adp.lib.g.e.jH().postDelayed(this.cJD, 1000L);
        this.cJy = new HashSet();
        this.cJz = new HashSet();
        this.cJA = new HashSet();
    }

    public static d auZ() {
        if (cJu == null) {
            synchronized (d.class) {
                if (cJu == null) {
                    cJu = new d();
                }
            }
        }
        return cJu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ava() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avb() {
        this.cJB = true;
        for (b bVar : this.cJy) {
            if (bVar != null) {
                bVar.avc();
            }
        }
        this.cJB = false;
        this.cJy.addAll(this.cJA);
        this.cJA.clear();
        this.cJy.removeAll(this.cJz);
        this.cJz.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cJv && this.cJw != null) {
            try {
                return this.cJw.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.cJD, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cJC = aVar;
    }

    public void a(b bVar) {
        if (this.cJB) {
            this.cJA.add(bVar);
        } else {
            this.cJy.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cJB) {
            this.cJA.remove(bVar);
        } else {
            this.cJy.remove(bVar);
        }
    }
}
