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
    private static q aie;
    private BroadcastReceiver aif;
    private ContentObserver aig;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<u> aih = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable aii = new r(this);

    public static q xY() {
        if (aie == null) {
            aie = new q();
            aie.init(com.baidu.tieba.aj.wm().getApp());
        }
        return aie;
    }

    private q() {
    }

    private void init(Context context) {
        this.aif = new s(this);
        this.aig = new t(this, this.mHandler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.aif, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.aig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            bk(true);
            return;
        }
        this.handler.removeCallbacks(this.aii);
        this.handler.postDelayed(this.aii, 2000L);
    }

    public void bk(boolean z) {
        Iterator<u> it = this.aih.iterator();
        while (it.hasNext()) {
            it.next().bl(z);
        }
    }

    public void a(u uVar) {
        if (uVar != null && !this.aih.contains(uVar)) {
            this.aih.add(uVar);
        }
    }

    public void b(u uVar) {
        if (this.aih.contains(uVar)) {
            this.aih.remove(uVar);
        }
    }

    public void xZ() {
        this.aih.clear();
    }

    public void ya() {
        xZ();
        Application app = com.baidu.tieba.aj.wm().getApp();
        app.unregisterReceiver(this.aif);
        app.getContentResolver().unregisterContentObserver(this.aig);
        aie = null;
    }
}
