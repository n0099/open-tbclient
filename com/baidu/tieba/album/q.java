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
    private static q a;
    private BroadcastReceiver c;
    private ContentObserver d;
    private Handler b = new Handler(Looper.getMainLooper());
    private ArrayList<u> e = new ArrayList<>();
    private Handler f = new Handler();
    private Runnable g = new r(this);

    public static q a() {
        if (a == null) {
            a = new q();
            a.a(com.baidu.tieba.ad.c().d());
        }
        return a;
    }

    private q() {
    }

    private void a(Context context) {
        this.c = new s(this);
        this.d = new t(this, this.b);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.c, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            a(true);
            return;
        }
        this.f.removeCallbacks(this.g);
        this.f.postDelayed(this.g, 2000L);
    }

    public void a(boolean z) {
        Iterator<u> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    public void a(u uVar) {
        if (uVar != null && !this.e.contains(uVar)) {
            this.e.add(uVar);
        }
    }

    public void b(u uVar) {
        if (this.e.contains(uVar)) {
            this.e.remove(uVar);
        }
    }

    public void b() {
        this.e.clear();
    }

    public void c() {
        b();
        Application d = com.baidu.tieba.ad.c().d();
        d.unregisterReceiver(this.c);
        d.getContentResolver().unregisterContentObserver(this.d);
        a = null;
    }
}
