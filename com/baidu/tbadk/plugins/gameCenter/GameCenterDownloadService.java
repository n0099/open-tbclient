package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class GameCenterDownloadService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (a.aRD() != null) {
            try {
                return a.aRD().onBind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROXY_GAME_DOWNLOAD_SERVICE_READY, this));
        if (a.aRD() != null) {
            try {
                a.aRD().onCreate();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (a.aRD() != null) {
            try {
                a.aRD().onStart(intent, i);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (a.aRD() != null) {
            try {
                return a.aRD().onStartCommand(intent, i, i2);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (a.aRD() != null) {
            try {
                a.aRD().onRebind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (a.aRD() != null) {
            try {
                return a.aRD().onUnbind(intent);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (a.aRD() != null) {
            try {
                a.aRD().onDestroy();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (a.aRD() != null) {
            a.aRD().onLowMemory();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.aRD() != null) {
            a.aRD().onConfigurationChanged(configuration);
        }
    }
}
