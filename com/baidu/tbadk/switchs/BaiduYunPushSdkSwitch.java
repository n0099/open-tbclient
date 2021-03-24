package com.baidu.tbadk.switchs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class BaiduYunPushSdkSwitch extends a {
    public static final String BAIDU_YUN_PUSH_SDK_KEY = "android_baiduyun_push";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001439));
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return BAIDU_YUN_PUSH_SDK_KEY;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
