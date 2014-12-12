package com.baidu.tieba.hao123;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
public class TiebaFloatingService extends BdBaseService implements View.OnClickListener, Runnable {
    public static final String TAG = "DemoService";
    private Hao123Plugin.IFloatingServiceCallback mFloatingServiceCallback = new Hao123Plugin.IFloatingServiceCallback() { // from class: com.baidu.tieba.hao123.TiebaFloatingService.1
        @Override // com.baidu.tbadk.plugins.Hao123Plugin.IFloatingServiceCallback
        public void stopSelf() {
            TiebaFloatingService.this.stopSelf();
        }

        @Override // com.baidu.tbadk.plugins.Hao123Plugin.IFloatingServiceCallback
        public void startForeground(int i, Notification notification) {
            TiebaFloatingService.this.startForeground(i, notification);
        }

        @Override // com.baidu.tbadk.plugins.Hao123Plugin.IFloatingServiceCallback
        public Runnable getRunnable() {
            return TiebaFloatingService.this;
        }
    };
    private Hao123Plugin mHao123Plugin;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mHao123Plugin != null) {
            this.mHao123Plugin.floatingServiceOnBind(intent);
            return null;
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mHao123Plugin = (Hao123Plugin) PluginCenter.gX().hc();
        if (this.mHao123Plugin != null) {
            this.mHao123Plugin.floatingServiceOnCreate(this, this.mFloatingServiceCallback);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mHao123Plugin != null) {
            this.mHao123Plugin.floatingServiceOnDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.mHao123Plugin != null) {
            this.mHao123Plugin.floatingServiceOnStartCommond(intent, i, i2);
            return 1;
        }
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mHao123Plugin != null) {
            this.mHao123Plugin.floatingServiceRun();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mHao123Plugin != null) {
            this.mHao123Plugin.floatingServiceOnClick(view);
        }
    }
}
