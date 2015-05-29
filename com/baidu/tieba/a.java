package com.baidu.tieba;

import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public interface a {
    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();
}
