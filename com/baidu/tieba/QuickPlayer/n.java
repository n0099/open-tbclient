package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.tieba.QuickPlayer.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ServiceConnection {
    final /* synthetic */ m aQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aQG = mVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aQG.aQD = true;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aQG.aQF;
        fS.removeCallbacks(runnable);
        this.aQG.aQE = d.a.d(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        this.aQG.aQD = false;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aQG.aQF;
        fS.postDelayed(runnable, 1000L);
    }
}
