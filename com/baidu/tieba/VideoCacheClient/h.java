package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ServiceConnection {
    final /* synthetic */ f aPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aPn = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aPn.aKA = true;
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.aPn.aKC;
        eE.removeCallbacks(runnable);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        File file = new File(d.aOW);
        if (file.exists()) {
            file.delete();
        }
        c.KK().KM();
        this.aPn.aKA = false;
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.aPn.aKC;
        eE.postDelayed(runnable, 1000L);
    }
}
