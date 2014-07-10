package com.baidu.tbadk.tbplugin;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ServiceConnection {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        WeakReference weakReference;
        this.a.b = new Messenger(iBinder);
        this.a.c = true;
        weakReference = this.a.e;
        n nVar = (n) weakReference.get();
        if (nVar != null) {
            nVar.l();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        WeakReference weakReference;
        this.a.b = null;
        this.a.c = false;
        weakReference = this.a.e;
        n nVar = (n) weakReference.get();
        if (nVar != null) {
            nVar.m();
        }
    }
}
