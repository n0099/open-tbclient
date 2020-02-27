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
/* loaded from: classes13.dex */
public class d {
    private static d dUO;
    private IQuickMediaPlayerService dUQ;
    private Set<b> dUS;
    private Set<b> dUT;
    private Set<b> dUU;
    private boolean dUV;
    private a dUW;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean dUP = false;
    private boolean dUR = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.dUP = true;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(d.this.dUX);
            d.this.dUQ = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.dUR) {
                d.this.dUR = false;
                d.this.aWy();
            }
            if (d.this.dUW != null) {
                d.this.dUW.a(d.this.dUQ);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.dUP = false;
            d.this.dUR = true;
            com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dUX, 1000L);
        }
    };
    private Runnable dUX = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.dUP) {
                d.this.aWx();
                com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dUX, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void aWz();
    }

    private d() {
        aWx();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dUX, 1000L);
        this.dUS = new HashSet();
        this.dUT = new HashSet();
        this.dUU = new HashSet();
    }

    public static d aWw() {
        if (dUO == null) {
            synchronized (d.class) {
                if (dUO == null) {
                    dUO = new d();
                }
            }
        }
        return dUO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWx() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWy() {
        this.dUV = true;
        for (b bVar : this.dUS) {
            if (bVar != null) {
                bVar.aWz();
            }
        }
        this.dUV = false;
        this.dUS.addAll(this.dUU);
        this.dUU.clear();
        this.dUS.removeAll(this.dUT);
        this.dUT.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.dUP && this.dUQ != null) {
            try {
                return this.dUQ.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dUX, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.dUW = aVar;
    }

    public void a(b bVar) {
        if (this.dUV) {
            this.dUU.add(bVar);
        } else {
            this.dUS.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.dUV) {
            this.dUU.remove(bVar);
        } else {
            this.dUS.remove(bVar);
        }
    }
}
