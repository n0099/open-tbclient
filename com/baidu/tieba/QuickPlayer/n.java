package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.tieba.QuickPlayer.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ServiceConnection {
    final /* synthetic */ m aQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aQo = mVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aQo.aQl = true;
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.aQo.aQn;
        fM.removeCallbacks(runnable);
        this.aQo.aQm = d.a.d(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        this.aQo.aQl = false;
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.aQo.aQn;
        fM.postDelayed(runnable, 1000L);
    }
}
