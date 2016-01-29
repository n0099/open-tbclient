package com.baidu.tbadk.plugins.bcsdk;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
/* loaded from: classes.dex */
public class BcSdkDownloadService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (a.Gl() != null) {
            return a.Gl().onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (a.Gl() != null) {
            a.Gl().onCreate();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (a.Gl() != null) {
            a.Gl().onStart(intent, i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return a.Gl() != null ? a.Gl().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (a.Gl() != null) {
            a.Gl().onRebind(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return a.Gl() != null ? a.Gl().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (a.Gl() != null) {
            a.Gl().onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (a.Gl() != null) {
            a.Gl().onLowMemory();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.Gl() != null) {
            a.Gl().onConfigurationChanged(configuration);
        }
    }
}
