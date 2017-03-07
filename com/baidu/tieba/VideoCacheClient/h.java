package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ServiceConnection {
    final /* synthetic */ f aUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aUZ = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aUZ.aQl = true;
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.aUZ.aQn;
        fM.removeCallbacks(runnable);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        File file = new File(d.aUI);
        if (file.exists()) {
            file.delete();
        }
        c.Lp().Lr();
        this.aUZ.aQl = false;
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.aUZ.aQn;
        fM.postDelayed(runnable, 1000L);
    }
}
