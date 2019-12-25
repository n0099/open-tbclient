package com.baidu.tbadk.switchs;
/* loaded from: classes.dex */
public class QuickWebViewSwitch extends BaseNormalSwitch {
    private static QuickWebViewSwitch mInstance = new QuickWebViewSwitch();

    public static boolean getInOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "android_custom_offline_web_cache";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    public int getDefaultType() {
        return super.getDefaultType();
    }
}
