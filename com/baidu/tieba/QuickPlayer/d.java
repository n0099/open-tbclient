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
    private static d cRG;
    private IQuickMediaPlayerService cRI;
    private Set<b> cRK;
    private Set<b> cRL;
    private Set<b> cRM;
    private boolean cRN;
    private a cRO;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cRH = false;
    private boolean cRJ = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cRH = true;
            com.baidu.adp.lib.g.e.iB().removeCallbacks(d.this.cRP);
            d.this.cRI = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cRJ) {
                d.this.cRJ = false;
                d.this.aAj();
            }
            if (d.this.cRO != null) {
                d.this.cRO.a(d.this.cRI);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cRH = false;
            d.this.cRJ = true;
            com.baidu.adp.lib.g.e.iB().postDelayed(d.this.cRP, 1000L);
        }
    };
    private Runnable cRP = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cRH) {
                d.this.aAi();
                com.baidu.adp.lib.g.e.iB().postDelayed(d.this.cRP, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aAk();
    }

    private d() {
        aAi();
        com.baidu.adp.lib.g.e.iB().postDelayed(this.cRP, 1000L);
        this.cRK = new HashSet();
        this.cRL = new HashSet();
        this.cRM = new HashSet();
    }

    public static d aAh() {
        if (cRG == null) {
            synchronized (d.class) {
                if (cRG == null) {
                    cRG = new d();
                }
            }
        }
        return cRG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAi() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAj() {
        this.cRN = true;
        for (b bVar : this.cRK) {
            if (bVar != null) {
                bVar.aAk();
            }
        }
        this.cRN = false;
        this.cRK.addAll(this.cRM);
        this.cRM.clear();
        this.cRK.removeAll(this.cRL);
        this.cRL.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cRH && this.cRI != null) {
            try {
                return this.cRI.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.cRP, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cRO = aVar;
    }

    public void a(b bVar) {
        if (this.cRN) {
            this.cRM.add(bVar);
        } else {
            this.cRK.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cRN) {
            this.cRM.remove(bVar);
        } else {
            this.cRK.remove(bVar);
        }
    }
}
