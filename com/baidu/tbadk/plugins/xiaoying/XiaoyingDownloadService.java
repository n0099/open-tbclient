package com.baidu.tbadk.plugins.xiaoying;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.tbadk.plugins.XiaoyingPlugin;
/* loaded from: classes.dex */
public class XiaoyingDownloadService extends IntentService {
    private static final String NAME = "XiaoyingDownloadService";

    public XiaoyingDownloadService(String str) {
        super(NAME);
    }

    public XiaoyingDownloadService() {
        super(NAME);
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (XiaoyingPlugin.getDownloadService() != null) {
            return XiaoyingPlugin.getDownloadService().onBind(intent);
        }
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (XiaoyingPlugin.getDownloadService() != null) {
            XiaoyingPlugin.getDownloadService().onCreate();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (XiaoyingPlugin.getDownloadService() != null) {
            XiaoyingPlugin.getDownloadService().onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return XiaoyingPlugin.getDownloadService() != null ? XiaoyingPlugin.getDownloadService().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        if (XiaoyingPlugin.getDownloadService() != null) {
            XiaoyingPlugin.getDownloadService().onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (XiaoyingPlugin.getDownloadService() != null) {
            XiaoyingPlugin.getDownloadService().onRebind(intent);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return XiaoyingPlugin.getDownloadService() != null ? XiaoyingPlugin.getDownloadService().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (XiaoyingPlugin.getDownloadService() != null) {
            XiaoyingPlugin.getDownloadService().onStart(intent, i);
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
    }
}
