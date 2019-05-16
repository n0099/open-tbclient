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
    private static d cRE;
    private IQuickMediaPlayerService cRG;
    private Set<b> cRI;
    private Set<b> cRJ;
    private Set<b> cRK;
    private boolean cRL;
    private a cRM;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cRF = false;
    private boolean cRH = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cRF = true;
            com.baidu.adp.lib.g.e.iB().removeCallbacks(d.this.cRN);
            d.this.cRG = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cRH) {
                d.this.cRH = false;
                d.this.aAg();
            }
            if (d.this.cRM != null) {
                d.this.cRM.a(d.this.cRG);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cRF = false;
            d.this.cRH = true;
            com.baidu.adp.lib.g.e.iB().postDelayed(d.this.cRN, 1000L);
        }
    };
    private Runnable cRN = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cRF) {
                d.this.aAf();
                com.baidu.adp.lib.g.e.iB().postDelayed(d.this.cRN, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aAh();
    }

    private d() {
        aAf();
        com.baidu.adp.lib.g.e.iB().postDelayed(this.cRN, 1000L);
        this.cRI = new HashSet();
        this.cRJ = new HashSet();
        this.cRK = new HashSet();
    }

    public static d aAe() {
        if (cRE == null) {
            synchronized (d.class) {
                if (cRE == null) {
                    cRE = new d();
                }
            }
        }
        return cRE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAf() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAg() {
        this.cRL = true;
        for (b bVar : this.cRI) {
            if (bVar != null) {
                bVar.aAh();
            }
        }
        this.cRL = false;
        this.cRI.addAll(this.cRK);
        this.cRK.clear();
        this.cRI.removeAll(this.cRJ);
        this.cRJ.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cRF && this.cRG != null) {
            try {
                return this.cRG.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.cRN, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cRM = aVar;
    }

    public void a(b bVar) {
        if (this.cRL) {
            this.cRK.add(bVar);
        } else {
            this.cRI.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cRL) {
            this.cRK.remove(bVar);
        } else {
            this.cRI.remove(bVar);
        }
    }
}
