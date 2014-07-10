package com.baidu.tbadk.plugins;

import android.content.Context;
import android.graphics.Bitmap;
@com.baidu.tbadk.tbplugin.a.a(a = "motusdk.jar", b = "com.baidu.tbplugin.impl.MotuPluginImpl")
@com.baidu.tbadk.tbplugin.a.b(a = {"libmtprocessor-jni.so", "libopengljni.so"})
@com.baidu.tbadk.tbplugin.a.c(a = "motusdk")
/* loaded from: classes.dex */
public interface MotuPlugin {
    Bitmap createOneKeyFilterAndApply(Context context, String str, Bitmap bitmap);

    void init(Context context);

    void startActivity(Context context, int i, String str);
}
