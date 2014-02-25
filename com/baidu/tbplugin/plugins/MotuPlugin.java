package com.baidu.tbplugin.plugins;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.tbplugin.a.a;
import com.baidu.tbplugin.a.b;
import com.baidu.tbplugin.a.c;
@c(a = "motusdk")
@b(a = {"libmtprocessor-jni.so", "libopengljni.so"})
@a(a = "motusdk.jar", b = "com.baidu.tbplugin.impl.MotuPluginImpl")
/* loaded from: classes.dex */
public interface MotuPlugin {
    Bitmap createOneKeyFilterAndApply(Context context, String str, Bitmap bitmap);

    void startActivity(Context context, int i, String str);
}
