package com.baidu.tieba.album;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class q {
    private static q a;
    private BroadcastReceiver c;
    private ContentObserver d;
    private Handler b = new Handler(Looper.getMainLooper());
    private ArrayList<u> e = new ArrayList<>();
    private Handler f = new Handler();
    private Runnable g = new r(this);

    public static q a() {
        if (a == null) {
            q qVar = new q();
            a = qVar;
            Application b = TiebaApplication.g().b();
            qVar.c = new s(qVar);
            qVar.d = new t(qVar, qVar.b);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
            intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addDataScheme("file");
            b.registerReceiver(qVar.c, intentFilter);
            b.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, qVar.d);
        }
        return a;
    }

    private q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(q qVar, Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            qVar.a(true);
            return;
        }
        qVar.f.removeCallbacks(qVar.g);
        qVar.f.postDelayed(qVar.g, 2000L);
    }

    public final void a(boolean z) {
        Iterator<u> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    public final void a(u uVar) {
        if (uVar != null && !this.e.contains(uVar)) {
            this.e.add(uVar);
        }
    }

    public final void b(u uVar) {
        if (this.e.contains(uVar)) {
            this.e.remove(uVar);
        }
    }

    public final void b() {
        this.e.clear();
        Application b = TiebaApplication.g().b();
        b.unregisterReceiver(this.c);
        b.getContentResolver().unregisterContentObserver(this.d);
        a = null;
    }
}
