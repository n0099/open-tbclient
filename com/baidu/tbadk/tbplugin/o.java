package com.baidu.tbadk.tbplugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class o implements PluginSync {
    private Context a;
    private Messenger b;
    private boolean c;
    private PluginsConfig d;
    private WeakReference<n> e;
    private List<WeakReference<r>> f = Collections.synchronizedList(new ArrayList());
    private final Messenger g = new Messenger(new q(this, null));
    private ServiceConnection h = new p(this);

    public o(Context context, n nVar) {
        try {
            Intent intent = new Intent(context, Class.forName("com.baidu.tbadk.core.service.PluginSyncService"));
            this.a = context;
            if (this.a.bindService(intent, this.h, 1)) {
                BdLog.d("Bind service success");
            } else {
                BdLog.d("Bind service failed");
            }
        } catch (ClassNotFoundException e) {
            BdLog.d("ClassNotFoundException");
        }
        this.e = new WeakReference<>(nVar);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0032 -> B:48:0x0027). Please submit an issue!!! */
    @Override // com.baidu.tbadk.tbplugin.PluginSync
    public PluginsConfig a() {
        if (this.d == null) {
            try {
                if (this.b == null) {
                    try {
                        if (this.a.bindService(new Intent(this.a, Class.forName("com.baidu.tbadk.core.service.PluginSyncService")), this.h, 1)) {
                            BdLog.d("Bind service success");
                        } else {
                            BdLog.d("Bind service failed");
                        }
                    } catch (ClassNotFoundException e) {
                        BdLog.d("ClassNotFoundException");
                    }
                } else {
                    Message obtain = Message.obtain((Handler) null, 2);
                    if (obtain != null) {
                        obtain.replyTo = this.g;
                        this.b.send(obtain);
                        BdLog.d("MSG_GET_CONFIG request");
                    }
                }
            } catch (RemoteException e2) {
            }
        }
        return this.d;
    }

    @Override // com.baidu.tbadk.tbplugin.PluginSync
    public PluginsConfig a(r rVar) {
        this.f.add(new WeakReference<>(rVar));
        return a();
    }

    protected void finalize() {
        super.finalize();
        if (this.a != null && this.h != null) {
            this.a.unbindService(this.h);
        }
    }
}
