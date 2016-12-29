package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ServiceConnection {
    final /* synthetic */ f aQl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aQl = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aQl.aLy = true;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.aQl.aLA;
        eG.removeCallbacks(runnable);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        File file = new File(d.aPT);
        if (file.exists()) {
            file.delete();
        }
        c.Kv().Kx();
        this.aQl.aLy = false;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.aQl.aLA;
        eG.postDelayed(runnable, 1000L);
    }
}
