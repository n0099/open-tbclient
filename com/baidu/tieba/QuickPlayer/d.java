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
    private static d cRF;
    private IQuickMediaPlayerService cRH;
    private Set<b> cRJ;
    private Set<b> cRK;
    private Set<b> cRL;
    private boolean cRM;
    private a cRN;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cRG = false;
    private boolean cRI = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cRG = true;
            com.baidu.adp.lib.g.e.iB().removeCallbacks(d.this.cRO);
            d.this.cRH = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cRI) {
                d.this.cRI = false;
                d.this.aAj();
            }
            if (d.this.cRN != null) {
                d.this.cRN.a(d.this.cRH);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cRG = false;
            d.this.cRI = true;
            com.baidu.adp.lib.g.e.iB().postDelayed(d.this.cRO, 1000L);
        }
    };
    private Runnable cRO = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cRG) {
                d.this.aAi();
                com.baidu.adp.lib.g.e.iB().postDelayed(d.this.cRO, 1000L);
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
        com.baidu.adp.lib.g.e.iB().postDelayed(this.cRO, 1000L);
        this.cRJ = new HashSet();
        this.cRK = new HashSet();
        this.cRL = new HashSet();
    }

    public static d aAh() {
        if (cRF == null) {
            synchronized (d.class) {
                if (cRF == null) {
                    cRF = new d();
                }
            }
        }
        return cRF;
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
        this.cRM = true;
        for (b bVar : this.cRJ) {
            if (bVar != null) {
                bVar.aAk();
            }
        }
        this.cRM = false;
        this.cRJ.addAll(this.cRL);
        this.cRL.clear();
        this.cRJ.removeAll(this.cRK);
        this.cRK.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cRG && this.cRH != null) {
            try {
                return this.cRH.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.cRO, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cRN = aVar;
    }

    public void a(b bVar) {
        if (this.cRM) {
            this.cRL.add(bVar);
        } else {
            this.cRJ.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cRM) {
            this.cRL.remove(bVar);
        } else {
            this.cRJ.remove(bVar);
        }
    }
}
