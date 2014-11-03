package com.baidu.tbadk.plugins;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public interface XiubaPlugin {
    void Xiu8PushService_onCreate(Context context);

    void Xiu8PushService_onDestroy();

    int Xiu8PushService_onStartCommand(Intent intent, int i, int i2);

    void init(Context context);

    void startLivingRoom(Context context, String str);

    void startUpReceiver_onReceive(Context context, Intent intent);

    void startXiuba(Context context);
}
