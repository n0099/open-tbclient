package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class GameCenterDownloadService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (a.awa() != null) {
            try {
                return a.awa().onBind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016519, this));
        if (a.awa() != null) {
            try {
                a.awa().onCreate();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (a.awa() != null) {
            try {
                a.awa().onStart(intent, i);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (a.awa() != null) {
            try {
                return a.awa().onStartCommand(intent, i, i2);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (a.awa() != null) {
            try {
                a.awa().onRebind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (a.awa() != null) {
            try {
                return a.awa().onUnbind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (a.awa() != null) {
            try {
                a.awa().onDestroy();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (a.awa() != null) {
            a.awa().onLowMemory();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.awa() != null) {
            a.awa().onConfigurationChanged(configuration);
        }
    }
}
