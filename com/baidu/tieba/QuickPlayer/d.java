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
    private static d btX;
    private IQuickMediaPlayerService btZ;
    private Set<b> bub;
    private Set<b> buc;
    private Set<b> bud;
    private boolean bue;
    private a bug;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean btY = false;
    private boolean bua = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.btY = true;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.buh);
            d.this.btZ = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bua) {
                d.this.bua = false;
                d.this.TB();
            }
            if (d.this.bug != null) {
                d.this.bug.a(d.this.btZ);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.btY = false;
            d.this.bua = true;
            com.baidu.adp.lib.g.e.jG().postDelayed(d.this.buh, 1000L);
        }
    };
    private Runnable buh = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.btY) {
                d.this.TA();
                com.baidu.adp.lib.g.e.jG().postDelayed(d.this.buh, 1000L);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void TC();
    }

    private d() {
        TA();
        com.baidu.adp.lib.g.e.jG().postDelayed(this.buh, 1000L);
        this.bub = new HashSet();
        this.buc = new HashSet();
        this.bud = new HashSet();
    }

    public static d Tz() {
        if (btX == null) {
            synchronized (d.class) {
                if (btX == null) {
                    btX = new d();
                }
            }
        }
        return btX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TA() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TB() {
        this.bue = true;
        for (b bVar : this.bub) {
            if (bVar != null) {
                bVar.TC();
            }
        }
        this.bue = false;
        this.bub.addAll(this.bud);
        this.bud.clear();
        this.bub.removeAll(this.buc);
        this.buc.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.btY && this.btZ != null) {
            try {
                return this.btZ.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.buh, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.bug = aVar;
    }

    public void a(b bVar) {
        if (this.bue) {
            this.bud.add(bVar);
        } else {
            this.bub.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bue) {
            this.bud.remove(bVar);
        } else {
            this.bub.remove(bVar);
        }
    }
}
