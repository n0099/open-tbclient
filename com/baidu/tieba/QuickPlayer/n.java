package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.tieba.QuickPlayer.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ServiceConnection {
    final /* synthetic */ m aMk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aMk = mVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Runnable runnable;
        this.aMk.aMh = true;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.aMk.aMj;
        eG.removeCallbacks(runnable);
        this.aMk.aMi = d.a.d(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Runnable runnable;
        this.aMk.aMh = false;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.aMk.aMj;
        eG.postDelayed(runnable, 1000L);
    }
}
