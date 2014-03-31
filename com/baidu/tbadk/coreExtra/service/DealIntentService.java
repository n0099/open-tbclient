package com.baidu.tbadk.coreExtra.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes.dex */
public class DealIntentService extends Service {
    private static String b = "TaskExsits";
    private static String c = "TaskNeedsTobeStart";
    private a a = null;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            if (this.a != null) {
                this.a.cancel();
                this.a = null;
            }
            this.a = new a(this, intent);
            this.a.setImmediatelyExecut(true);
            this.a.execute(new String[0]);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
