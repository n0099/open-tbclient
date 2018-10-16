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
/* loaded from: classes5.dex */
public class d {
    private static d btk;
    private IQuickMediaPlayerService btm;
    private Set<b> btp;
    private Set<b> btq;
    private Set<b> btr;
    private boolean bts;
    private a btt;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean btl = false;
    private boolean bto = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.btl = true;
            com.baidu.adp.lib.g.e.jI().removeCallbacks(d.this.btu);
            d.this.btm = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bto) {
                d.this.bto = false;
                d.this.Ts();
            }
            if (d.this.btt != null) {
                d.this.btt.a(d.this.btm);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.btl = false;
            d.this.bto = true;
            com.baidu.adp.lib.g.e.jI().postDelayed(d.this.btu, 1000L);
        }
    };
    private Runnable btu = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.btl) {
                d.this.Tr();
                com.baidu.adp.lib.g.e.jI().postDelayed(d.this.btu, 1000L);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void Tt();
    }

    private d() {
        Tr();
        com.baidu.adp.lib.g.e.jI().postDelayed(this.btu, 1000L);
        this.btp = new HashSet();
        this.btq = new HashSet();
        this.btr = new HashSet();
    }

    public static d Tq() {
        if (btk == null) {
            synchronized (d.class) {
                if (btk == null) {
                    btk = new d();
                }
            }
        }
        return btk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tr() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ts() {
        this.bts = true;
        for (b bVar : this.btp) {
            if (bVar != null) {
                bVar.Tt();
            }
        }
        this.bts = false;
        this.btp.addAll(this.btr);
        this.btr.clear();
        this.btp.removeAll(this.btq);
        this.btq.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.btl && this.btm != null) {
            try {
                return this.btm.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.btu, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.btt = aVar;
    }

    public void a(b bVar) {
        if (this.bts) {
            this.btr.add(bVar);
        } else {
            this.btp.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bts) {
            this.btr.remove(bVar);
        } else {
            this.btp.remove(bVar);
        }
    }
}
