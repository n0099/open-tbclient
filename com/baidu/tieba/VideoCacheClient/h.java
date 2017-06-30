package com.baidu.tieba.VideoCacheClient;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements ServiceConnection {
    final /* synthetic */ f aUD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aUD = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aUD.aSq = true;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.aUD.aSs;
        fR.removeCallbacks(runnable);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        File file = new File(d.aUn);
        if (file.exists()) {
            file.delete();
        }
        c.Kw().Ky();
        this.aUD.aSq = false;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.aUD.aSs;
        fR.postDelayed(runnable, 1000L);
    }
}
