package com.baidu.tbadk.plugins.xiaoying;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.tbadk.plugins.XiaoyingPlugin;
/* loaded from: classes.dex */
public class XiaoyingShareService extends IntentService {
    private static final String NAME = "XiaoyingShareService";

    public XiaoyingShareService(String str) {
        super(NAME);
    }

    public XiaoyingShareService() {
        super(NAME);
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (XiaoyingPlugin.getShareService() != null) {
            return XiaoyingPlugin.getShareService().onBind(intent);
        }
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (XiaoyingPlugin.getShareService() != null) {
            XiaoyingPlugin.getShareService().onCreate();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (XiaoyingPlugin.getShareService() != null) {
            XiaoyingPlugin.getShareService().onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return XiaoyingPlugin.getShareService() != null ? XiaoyingPlugin.getShareService().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        if (XiaoyingPlugin.getShareService() != null) {
            XiaoyingPlugin.getShareService().onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (XiaoyingPlugin.getShareService() != null) {
            XiaoyingPlugin.getShareService().onRebind(intent);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return XiaoyingPlugin.getShareService() != null ? XiaoyingPlugin.getShareService().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (XiaoyingPlugin.getShareService() != null) {
            XiaoyingPlugin.getShareService().onStart(intent, i);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
    }
}
