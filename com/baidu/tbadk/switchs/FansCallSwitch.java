package com.baidu.tbadk.switchs;
/* loaded from: classes.dex */
public class FansCallSwitch extends BaseNormalSwitch {
    private static final FansCallSwitch mInstance = new FansCallSwitch();

    public static boolean getIsOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "android_show_call_followers";
    }
}
