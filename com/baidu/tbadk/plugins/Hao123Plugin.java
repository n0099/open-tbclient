package com.baidu.tbadk.plugins;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
public interface Hao123Plugin {

    /* loaded from: classes.dex */
    public interface IFloatingServiceCallback {
        Runnable getRunnable();

        void startForeground(int i, Notification notification);

        void stopSelf();
    }

    void brBootOnReceiver(Context context, Intent intent);

    void closeFloating(Context context);

    void floatingServiceOnBind(Intent intent);

    void floatingServiceOnClick(View view);

    void floatingServiceOnCreate(Context context, IFloatingServiceCallback iFloatingServiceCallback);

    void floatingServiceOnDestroy();

    void floatingServiceOnStartCommond(Intent intent, int i, int i2);

    void floatingServiceRun();

    void init();

    void openFloating(Context context);
}
