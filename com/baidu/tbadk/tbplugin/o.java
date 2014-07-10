package com.baidu.tbadk.tbplugin;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
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

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.tbplugin.q.handleMessage(android.os.Message):void] */
    public static /* synthetic */ void a(o oVar, PluginsConfig pluginsConfig) {
        oVar.d = pluginsConfig;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.tbplugin.q.handleMessage(android.os.Message):void] */
    public static /* synthetic */ PluginsConfig c(o oVar) {
        return oVar.d;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tbadk.tbplugin.q.handleMessage(android.os.Message):void] */
    public static /* synthetic */ List b(o oVar) {
        return oVar.f;
    }

    public o(Context context, n nVar) {
        try {
            Intent intent = new Intent(context, Class.forName("com.baidu.tbadk.core.service.PluginSyncService"));
            this.a = context;
            this.a.bindService(intent, this.h, 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.e = new WeakReference<>(nVar);
    }

    @Override // com.baidu.tbadk.tbplugin.PluginSync
    public PluginsConfig a() {
        if (this.d == null) {
            try {
                if (this.b == null) {
                    try {
                        this.a.bindService(new Intent(this.a, Class.forName("com.baidu.tbadk.core.service.PluginSyncService")), this.h, 1);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    Message obtain = Message.obtain((Handler) null, 2);
                    if (obtain != null) {
                        obtain.replyTo = this.g;
                        this.b.send(obtain);
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
