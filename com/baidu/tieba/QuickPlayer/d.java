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
    private static d bhm;
    private IQuickMediaPlayerService bho;
    private Set<b> bhq;
    private Set<b> bhr;
    private Set<b> bhs;
    private boolean bht;
    private a bhu;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bhn = false;
    private boolean bhp = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bhn = true;
            com.baidu.adp.lib.g.e.im().removeCallbacks(d.this.bhv);
            d.this.bho = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bhp) {
                d.this.bhp = false;
                d.this.Pa();
            }
            if (d.this.bhu != null) {
                d.this.bhu.a(d.this.bho);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bhn = false;
            d.this.bhp = true;
            com.baidu.adp.lib.g.e.im().postDelayed(d.this.bhv, 1000L);
        }
    };
    private Runnable bhv = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bhn) {
                d.this.OZ();
                com.baidu.adp.lib.g.e.im().postDelayed(d.this.bhv, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Pb();
    }

    private d() {
        OZ();
        com.baidu.adp.lib.g.e.im().postDelayed(this.bhv, 1000L);
        this.bhq = new HashSet();
        this.bhr = new HashSet();
        this.bhs = new HashSet();
    }

    public static d OY() {
        if (bhm == null) {
            synchronized (d.class) {
                if (bhm == null) {
                    bhm = new d();
                }
            }
        }
        return bhm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OZ() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pa() {
        this.bht = true;
        for (b bVar : this.bhq) {
            if (bVar != null) {
                bVar.Pb();
            }
        }
        this.bht = false;
        this.bhq.addAll(this.bhs);
        this.bhs.clear();
        this.bhq.removeAll(this.bhr);
        this.bhr.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bhn && this.bho != null) {
            try {
                return this.bho.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.im().postDelayed(this.bhv, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.bhu = aVar;
    }

    public void a(b bVar) {
        if (this.bht) {
            this.bhs.add(bVar);
        } else {
            this.bhq.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bht) {
            this.bhs.remove(bVar);
        } else {
            this.bhq.remove(bVar);
        }
    }
}
