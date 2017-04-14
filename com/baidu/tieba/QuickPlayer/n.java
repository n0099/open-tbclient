package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.tieba.QuickPlayer.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ServiceConnection {
    final /* synthetic */ m aQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aQE = mVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aQE.aQB = true;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.aQE.aQD;
        fR.removeCallbacks(runnable);
        this.aQE.aQC = d.a.d(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        this.aQE.aQB = false;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.aQE.aQD;
        fR.postDelayed(runnable, 1000L);
    }
}
