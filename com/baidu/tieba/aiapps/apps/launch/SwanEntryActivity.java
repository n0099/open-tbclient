package com.baidu.tieba.aiapps.apps.launch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import d.b.g0.a.i2.u;
import d.b.g0.d.h.b;
/* loaded from: classes4.dex */
public class SwanEntryActivity extends Activity {
    public static final String LAUNCHER_URI = "SWAN_URI";
    public static final String SWAN_ACTION = "com.baidu.swan.launcher";

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanEntryActivity.this.finish();
        }
    }

    private void doLaunch() {
        String uri;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (TextUtils.equals(intent.getAction(), SWAN_ACTION)) {
            uri = intent.getStringExtra(LAUNCHER_URI);
        } else {
            Uri data = intent.getData();
            uri = data == null ? null : data.toString();
        }
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        b.a(uri);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d.b.c.a.a.b(this);
        super.onCreate(bundle);
        if (u.a(this)) {
            return;
        }
        doLaunch();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        doLaunch();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        runOnUiThread(new a());
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (d.b.c.a.a.d(this) && d.b.c.a.a.a(i)) {
            return;
        }
        super.setRequestedOrientation(i);
    }
}
