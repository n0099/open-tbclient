package com.baidu.tbadk.plugins.gameCenter;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GameCenterDownloadService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (a.GP() != null) {
            return a.GP().onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROXY_GAME_DOWNLOAD_SERVICE_READY, this));
        if (a.GP() != null) {
            a.GP().onCreate();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (a.GP() != null) {
            a.GP().onStart(intent, i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return a.GP() != null ? a.GP().onStartCommand(intent, i, i2) : super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (a.GP() != null) {
            a.GP().onRebind(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return a.GP() != null ? a.GP().onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (a.GP() != null) {
            a.GP().onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (a.GP() != null) {
            a.GP().onLowMemory();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.GP() != null) {
            a.GP().onConfigurationChanged(configuration);
        }
    }
}
