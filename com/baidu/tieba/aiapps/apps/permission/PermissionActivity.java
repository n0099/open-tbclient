package com.baidu.tieba.aiapps.apps.permission;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.tieba.R;
import d.a.o0.u.b.g.a;
/* loaded from: classes4.dex */
public class PermissionActivity extends Activity {
    public static final int PERMISSION_REQUEST_CODE = 999;

    private void init() {
        setContentView(R.layout.activity_permission);
        a.d(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (a.b(this, i2, strArr, iArr)) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }
}
