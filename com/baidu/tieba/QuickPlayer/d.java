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
    private static d bpk;
    private IQuickMediaPlayerService bpm;
    private Set<b> bpo;
    private Set<b> bpp;
    private Set<b> bpq;
    private boolean bpr;
    private a bps;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bpl = false;
    private boolean bpn = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bpl = true;
            com.baidu.adp.lib.g.e.jt().removeCallbacks(d.this.bpt);
            d.this.bpm = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bpn) {
                d.this.bpn = false;
                d.this.Rw();
            }
            if (d.this.bps != null) {
                d.this.bps.a(d.this.bpm);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bpl = false;
            d.this.bpn = true;
            com.baidu.adp.lib.g.e.jt().postDelayed(d.this.bpt, 1000L);
        }
    };
    private Runnable bpt = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bpl) {
                d.this.Rv();
                com.baidu.adp.lib.g.e.jt().postDelayed(d.this.bpt, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Rx();
    }

    private d() {
        Rv();
        com.baidu.adp.lib.g.e.jt().postDelayed(this.bpt, 1000L);
        this.bpo = new HashSet();
        this.bpp = new HashSet();
        this.bpq = new HashSet();
    }

    public static d Ru() {
        if (bpk == null) {
            synchronized (d.class) {
                if (bpk == null) {
                    bpk = new d();
                }
            }
        }
        return bpk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rv() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rw() {
        this.bpr = true;
        for (b bVar : this.bpo) {
            if (bVar != null) {
                bVar.Rx();
            }
        }
        this.bpr = false;
        this.bpo.addAll(this.bpq);
        this.bpq.clear();
        this.bpo.removeAll(this.bpp);
        this.bpp.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bpl && this.bpm != null) {
            try {
                return this.bpm.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jt().postDelayed(this.bpt, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.bps = aVar;
    }

    public void a(b bVar) {
        if (this.bpr) {
            this.bpq.add(bVar);
        } else {
            this.bpo.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bpr) {
            this.bpq.remove(bVar);
        } else {
            this.bpo.remove(bVar);
        }
    }
}
