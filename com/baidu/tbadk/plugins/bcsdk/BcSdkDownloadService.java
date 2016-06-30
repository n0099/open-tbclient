package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
/* loaded from: classes.dex */
public class BcSdkDownloadService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (a.Fn() != null) {
            return a.Fn().onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (a.Fn() != null) {
            a.Fn().onCreate();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (a.Fn() != null) {
            a.Fn().onStart(intent, i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return a.Fn() != null ? a.Fn().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (a.Fn() != null) {
            a.Fn().onRebind(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return a.Fn() != null ? a.Fn().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (a.Fn() != null) {
            a.Fn().onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (a.Fn() != null) {
            a.Fn().onLowMemory();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.Fn() != null) {
            a.Fn().onConfigurationChanged(configuration);
        }
    }
}
