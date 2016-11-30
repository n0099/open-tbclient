package com.baidu.tieba.VideoCache;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/* loaded from: classes.dex */
public class VideoCacheService extends Service {
    private static final String TAG = VideoCacheService.class.getSimpleName();
    private r mHttpServer;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m.log(TAG, "onCreate");
        this.mHttpServer = new r(this);
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
        m.log(TAG, "onDestroy");
        if (this.mHttpServer != null) {
            this.mHttpServer.destroy();
        }
        p.KX().destroy();
    }
}
