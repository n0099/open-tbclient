package com.baidu.tbadk.plugins;

import android.content.Context;
@com.baidu.tbadk.tbplugin.a.a(a = "dqsdk.jar", b = "dex.wrapper.DQSdkImpl")
@com.baidu.tbadk.tbplugin.a.c(a = "dqsdk")
/* loaded from: classes.dex */
public interface DQSdkPlugin {
    void initDQ(Context context);

    void startActivity(Context context, String str, String str2, String str3, String str4, String str5);
}
