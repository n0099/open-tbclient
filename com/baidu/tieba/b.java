package com.baidu.tieba;

import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public interface b {
    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();
}
