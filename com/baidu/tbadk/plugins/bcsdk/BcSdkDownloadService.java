package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
/* loaded from: classes.dex */
public class BcSdkDownloadService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (a.Fe() != null) {
            return a.Fe().onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (a.Fe() != null) {
            a.Fe().onCreate();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (a.Fe() != null) {
            a.Fe().onStart(intent, i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return a.Fe() != null ? a.Fe().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (a.Fe() != null) {
            a.Fe().onRebind(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return a.Fe() != null ? a.Fe().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (a.Fe() != null) {
            a.Fe().onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (a.Fe() != null) {
            a.Fe().onLowMemory();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.Fe() != null) {
            a.Fe().onConfigurationChanged(configuration);
        }
    }
}
