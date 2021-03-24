package com.baidu.tbadk.switchs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class XiaomiPushSdkSwitch extends a {
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;
    public static final String XIAOMIPUSH_SDK_KEY = "switch_xiaomipush_sdk";

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001310));
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
        return XIAOMIPUSH_SDK_KEY;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
