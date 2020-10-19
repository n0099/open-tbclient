package com.baidu.tieba.aiapps.apps.permission;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class PermissionActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    private void init() {
        setContentView(R.layout.activity_permission);
        a.eQ(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!a.a(this, i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
