package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ServiceConnection {
    final /* synthetic */ f aVo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aVo = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aVo.aQD = true;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aVo.aQF;
        fS.removeCallbacks(runnable);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        File file = new File(d.aUX);
        if (file.exists()) {
            file.delete();
        }
        c.LP().LR();
        this.aVo.aQD = false;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aVo.aQF;
        fS.postDelayed(runnable, 1000L);
    }
}
