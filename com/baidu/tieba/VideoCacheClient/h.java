package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements ServiceConnection {
    final /* synthetic */ f aTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aTk = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aTk.aQX = true;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aTk.aQZ;
        fS.removeCallbacks(runnable);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        File file = new File(d.aSU);
        if (file.exists()) {
            file.delete();
        }
        c.JY().Ka();
        this.aTk.aQX = false;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aTk.aQZ;
        fS.postDelayed(runnable, 1000L);
    }
}
