package com.baidu.tieba.VideoCache;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes9.dex */
public class VideoCacheService extends Service {
    private static final String TAG = VideoCacheService.class.getSimpleName();
    private n mHttpServer;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        j.D(TAG, MissionEvent.MESSAGE_CREATE);
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
        j.D(TAG, MissionEvent.MESSAGE_DESTROY);
        if (this.mHttpServer != null) {
            this.mHttpServer.destroy();
        }
        l.blI().destroy();
    }
}
