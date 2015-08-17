package com.baidu.tbadk.plugins.xiaoying;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.tbadk.plugins.XiaoyingPlugin;
/* loaded from: classes.dex */
public class XiaoyingSocialService extends IntentService {
    private static final String NAME = "XiaoyingSocialService";

    public XiaoyingSocialService(String str) {
        super(NAME);
    }

    public XiaoyingSocialService() {
        super(NAME);
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (XiaoyingPlugin.getSocialService() != null) {
            return XiaoyingPlugin.getSocialService().onBind(intent);
        }
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (XiaoyingPlugin.getSocialService() != null) {
            XiaoyingPlugin.getSocialService().onCreate();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (XiaoyingPlugin.getSocialService() != null) {
            XiaoyingPlugin.getSocialService().onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return XiaoyingPlugin.getSocialService() != null ? XiaoyingPlugin.getSocialService().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        if (XiaoyingPlugin.getSocialService() != null) {
            XiaoyingPlugin.getSocialService().onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (XiaoyingPlugin.getSocialService() != null) {
            XiaoyingPlugin.getSocialService().onRebind(intent);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return XiaoyingPlugin.getSocialService() != null ? XiaoyingPlugin.getSocialService().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (XiaoyingPlugin.getSocialService() != null) {
            XiaoyingPlugin.getSocialService().onStart(intent, i);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
    }
}
