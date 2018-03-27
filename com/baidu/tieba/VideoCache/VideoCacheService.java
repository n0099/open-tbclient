package com.baidu.tieba.VideoCache;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/* loaded from: classes2.dex */
public class VideoCacheService extends Service {
    private static final String TAG = VideoCacheService.class.getSimpleName();
    private n mHttpServer;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        j.au(TAG, "onCreate");
        this.mHttpServer = new n(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        j.au(TAG, "onDestroy");
        if (this.mHttpServer != null) {
            this.mHttpServer.destroy();
        }
        l.TR().destroy();
    }
}
