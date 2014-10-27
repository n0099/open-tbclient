package com.baidu.tieba.album;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class q {
    private static q ahV;
    private BroadcastReceiver ahW;
    private ContentObserver ahX;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<u> ahY = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable ahZ = new r(this);

    public static q xW() {
        if (ahV == null) {
            ahV = new q();
            ahV.init(com.baidu.tieba.aj.wk().getApp());
        }
        return ahV;
    }

    private q() {
    }

    private void init(Context context) {
        this.ahW = new s(this);
        this.ahX = new t(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.ahW, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.ahX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            bk(true);
            return;
        }
        this.handler.removeCallbacks(this.ahZ);
        this.handler.postDelayed(this.ahZ, 2000L);
    }

    public void bk(boolean z) {
        Iterator<u> it = this.ahY.iterator();
        while (it.hasNext()) {
            it.next().bl(z);
        }
    }

    public void a(u uVar) {
        if (uVar != null && !this.ahY.contains(uVar)) {
            this.ahY.add(uVar);
        }
    }

    public void b(u uVar) {
        if (this.ahY.contains(uVar)) {
            this.ahY.remove(uVar);
        }
    }

    public void xX() {
        this.ahY.clear();
    }

    public void xY() {
        xX();
        Application app = com.baidu.tieba.aj.wk().getApp();
        app.unregisterReceiver(this.ahW);
        app.getContentResolver().unregisterContentObserver(this.ahX);
        ahV = null;
    }
}
