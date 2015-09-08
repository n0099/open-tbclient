package com.baidu.tbadk.plugins.xiaoying;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.tbadk.plugins.XiaoyingPlugin;
/* loaded from: classes.dex */
public class XiaoyingTaskService extends IntentService {
    private static final String NAME = "XiaoyingTaskService";

    public XiaoyingTaskService(String str) {
        super(NAME);
    }

    public XiaoyingTaskService() {
        super(NAME);
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (XiaoyingPlugin.getTaskService() != null) {
            return XiaoyingPlugin.getTaskService().onBind(intent);
        }
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (XiaoyingPlugin.getTaskService() != null) {
            XiaoyingPlugin.getTaskService().onCreate();
            XiaoyingPlugin.getTaskService().setIntentRedelivery(false);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (XiaoyingPlugin.getTaskService() != null) {
            XiaoyingPlugin.getTaskService().onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return XiaoyingPlugin.getTaskService() != null ? XiaoyingPlugin.getTaskService().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        if (XiaoyingPlugin.getTaskService() != null) {
            XiaoyingPlugin.getTaskService().onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (XiaoyingPlugin.getTaskService() != null) {
            XiaoyingPlugin.getTaskService().onRebind(intent);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return XiaoyingPlugin.getTaskService() != null ? XiaoyingPlugin.getTaskService().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (XiaoyingPlugin.getTaskService() != null) {
            XiaoyingPlugin.getTaskService().onStart(intent, i);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
    }
}
