package com.baidu.tieba.hao123;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
/* loaded from: classes.dex */
public class TiebaFloatingService extends Service implements View.OnClickListener, Runnable {
    public static final String TAG = "DemoService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
