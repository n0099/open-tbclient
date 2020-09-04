package com.baidu.tbadk.switchs;

import com.facebook.common.util.TriState;
/* loaded from: classes.dex */
public class QuickWebViewSwitch extends BaseNormalSwitch {
    private static TriState state = TriState.UNSET;
    private static QuickWebViewSwitch mInstance = new QuickWebViewSwitch();

    public static boolean getInOn() {
        if (state == TriState.UNSET) {
            return mInstance.isOn();
        }
        if (state == TriState.YES) {
            return true;
        }
        return false;
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

    public static void setState(TriState triState) {
        state = triState;
    }
}
