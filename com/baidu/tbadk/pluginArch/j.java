package com.baidu.tbadk.pluginArch;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class j implements ServiceConnection {
    final /* synthetic */ h a;

    private j(h hVar) {
        this.a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(h hVar, j jVar) {
        this(hVar);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        h.a(this.a, new Messenger(iBinder));
        BdLog.i("startDownload_connected");
        h.b(this.a);
        if (h.c(this.a) != null) {
            h.a(this.a, h.c(this.a));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        h.a(this.a, (Messenger) null);
        h.b(this.a, null);
    }
}
