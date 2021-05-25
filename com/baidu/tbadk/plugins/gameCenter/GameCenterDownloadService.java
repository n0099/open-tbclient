package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import d.a.m0.p0.c.a;
/* loaded from: classes3.dex */
public class GameCenterDownloadService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (a.d() != null) {
            try {
                return a.d().onBind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.d() != null) {
            a.d().onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016519, this));
        if (a.d() != null) {
            try {
                a.d().onCreate();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (a.d() != null) {
            try {
                a.d().onDestroy();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (a.d() != null) {
            a.d().onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (a.d() != null) {
            try {
                a.d().onRebind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (a.d() != null) {
            try {
                a.d().onStart(intent, i2);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (a.d() != null) {
            try {
                return a.d().onStartCommand(intent, i2, i3);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return super.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (a.d() != null) {
            try {
                return a.d().onUnbind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return super.onUnbind(intent);
    }
}
