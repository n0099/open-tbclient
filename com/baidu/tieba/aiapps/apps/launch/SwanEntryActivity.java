package com.baidu.tieba.aiapps.apps.launch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.facade.b.b;
/* loaded from: classes12.dex */
public class SwanEntryActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!s.checkActivityRefuseServiceAndFinish(this)) {
            bod();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        bod();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.launch.SwanEntryActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SwanEntryActivity.this.finish();
            }
        });
    }

    private void bod() {
        String uri;
        Intent intent = getIntent();
        if (intent != null) {
            if (TextUtils.equals(intent.getAction(), "com.baidu.swan.launcher")) {
                uri = intent.getStringExtra("SWAN_URI");
            } else {
                Uri data = intent.getData();
                uri = data == null ? null : data.toString();
            }
            if (!TextUtils.isEmpty(uri)) {
                b.qj(uri);
            }
        }
    }
}
