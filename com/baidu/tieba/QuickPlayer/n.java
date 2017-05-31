package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.tieba.QuickPlayer.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ServiceConnection {
    final /* synthetic */ m aRa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aRa = mVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aRa.aQX = true;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aRa.aQZ;
        fS.removeCallbacks(runnable);
        this.aRa.aQY = d.a.d(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        this.aRa.aQX = false;
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.aRa.aQZ;
        fS.postDelayed(runnable, 1000L);
    }
}
