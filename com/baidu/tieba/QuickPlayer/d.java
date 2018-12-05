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
    private static d bxv;
    private Set<b> bxA;
    private Set<b> bxB;
    private boolean bxC;
    private a bxD;
    private IQuickMediaPlayerService bxx;
    private Set<b> bxz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bxw = false;
    private boolean bxy = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bxw = true;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(d.this.bxE);
            d.this.bxx = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bxy) {
                d.this.bxy = false;
                d.this.UH();
            }
            if (d.this.bxD != null) {
                d.this.bxD.a(d.this.bxx);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bxw = false;
            d.this.bxy = true;
            com.baidu.adp.lib.g.e.jG().postDelayed(d.this.bxE, 1000L);
        }
    };
    private Runnable bxE = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bxw) {
                d.this.UG();
                com.baidu.adp.lib.g.e.jG().postDelayed(d.this.bxE, 1000L);
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void UI();
    }

    private d() {
        UG();
        com.baidu.adp.lib.g.e.jG().postDelayed(this.bxE, 1000L);
        this.bxz = new HashSet();
        this.bxA = new HashSet();
        this.bxB = new HashSet();
    }

    public static d UF() {
        if (bxv == null) {
            synchronized (d.class) {
                if (bxv == null) {
                    bxv = new d();
                }
            }
        }
        return bxv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UG() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UH() {
        this.bxC = true;
        for (b bVar : this.bxz) {
            if (bVar != null) {
                bVar.UI();
            }
        }
        this.bxC = false;
        this.bxz.addAll(this.bxB);
        this.bxB.clear();
        this.bxz.removeAll(this.bxA);
        this.bxA.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bxw && this.bxx != null) {
            try {
                return this.bxx.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.bxE, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.bxD = aVar;
    }

    public void a(b bVar) {
        if (this.bxC) {
            this.bxB.add(bVar);
        } else {
            this.bxz.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.bxC) {
            this.bxB.remove(bVar);
        } else {
            this.bxz.remove(bVar);
        }
    }
}
