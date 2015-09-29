package com.baidu.tbadk.plugins.moplus;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class MoPlusService extends Service {
    private MoplusServiceInterface mInstance = null;

    public synchronized MoplusServiceInterface getInstance() {
        CustomResponsedMessage runTask;
        if (this.mInstance == null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_MOPLUS_GET_SERVICE, this), MoplusServiceInterface.class)) != null) {
            this.mInstance = (MoplusServiceInterface) runTask.getData();
        }
        return this.mInstance;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (getInstance() != null) {
            getInstance().attachBaseContext(this);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (getInstance() != null) {
            return getInstance().onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (getInstance() != null) {
            return getInstance().onStartCommand(intent, i, i2);
        }
        return 0;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (getInstance() != null) {
            return getInstance().onUnbind(intent);
        }
        return false;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        if (getInstance() != null) {
            getInstance().onRebind(intent);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        if (getInstance() != null) {
            getInstance().onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (getInstance() != null) {
            getInstance().onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (getInstance() != null) {
            getInstance().onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (getInstance() != null) {
            getInstance().onLowMemory();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (getInstance() != null) {
            getInstance().onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (getInstance() != null) {
            getInstance().onTaskRemoved(intent);
        }
    }
}
