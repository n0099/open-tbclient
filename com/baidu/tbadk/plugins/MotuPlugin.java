package com.baidu.tbadk.plugins;

import android.content.Context;
import android.graphics.Bitmap;
@com.baidu.tbplugin.a.c(a = "motusdk")
@com.baidu.tbplugin.a.b(a = {"libmtprocessor-jni.so", "libopengljni.so"})
@com.baidu.tbplugin.a.a(a = "motusdk.jar", b = "com.baidu.tbplugin.impl.MotuPluginImpl")
/* loaded from: classes.dex */
public interface MotuPlugin {
    Bitmap createOneKeyFilterAndApply(Context context, String str, Bitmap bitmap);

    void startActivity(Context context, int i, String str);
}
