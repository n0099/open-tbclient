package com.baidu.tieba.aiapps.apps.f;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.baidu.swan.apps.u.b.j;
import java.io.File;
/* loaded from: classes4.dex */
public class a implements j {
    @Override // com.baidu.swan.apps.u.b.j
    public boolean a(Activity activity, Uri uri, String str) {
        if (activity == null || uri == null || uri.getPath() == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.apps.an.a.hasNougat()) {
            uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".fileprovider", new File(uri.getPath()));
        }
        b(activity, uri, str);
        return true;
    }

    public void b(Activity activity, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(uri, str);
        activity.startActivity(intent);
    }
}
