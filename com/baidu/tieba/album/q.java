package com.baidu.tieba.album;

import android.content.BroadcastReceiver;
import android.content.Context;
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
public class q {
    private static q a;
    private Handler b = new Handler(Looper.getMainLooper());
    private ArrayList<t> e = new ArrayList<>();
    private BroadcastReceiver c = new r(this);
    private ContentObserver d = new s(this, this.b);

    public static q a() {
        if (a == null) {
            a = new q(TiebaApplication.g().b());
        }
        return a;
    }

    private q(Context context) {
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
        String action = intent.getAction();
        if (!action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                a(true);
            } else if (action.equals("android.intent.action.MEDIA_SCANNER_STARTED")) {
                a(false);
            } else if (action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                a(false);
            } else if (action.equals("android.intent.action.MEDIA_EJECT")) {
                a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Iterator<t> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    public void a(t tVar) {
        if (tVar != null && !this.e.contains(tVar)) {
            this.e.add(tVar);
        }
    }

    public void b(t tVar) {
        if (this.e.contains(tVar)) {
            this.e.remove(tVar);
        }
    }
}
