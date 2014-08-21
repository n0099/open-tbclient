package com.baidu.tbadk.pluginArch;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class k implements ServiceConnection {
    final /* synthetic */ i a;

    private k(i iVar) {
        this.a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(i iVar, k kVar) {
        this(iVar);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        i.a(this.a, new Messenger(iBinder));
        BdLog.i("startDownload_connected");
        i.b(this.a);
        if (i.c(this.a) != null) {
            i.a(this.a, i.c(this.a));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        i.a(this.a, (Messenger) null);
        i.b(this.a, null);
    }
}
