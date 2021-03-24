package com.baidu.tbadk.switchs;

import com.facebook.common.util.TriState;
/* loaded from: classes3.dex */
public class QuickWebViewSwitch extends BaseNormalSwitch {
    public static TriState state = TriState.UNSET;
    public static QuickWebViewSwitch mInstance = new QuickWebViewSwitch();

    public static boolean getInOn() {
        if (state == TriState.UNSET) {
            return mInstance.isOn();
        }
        return state == TriState.YES;
    }

    public static void setState(TriState triState) {
        state = triState;
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.b.b.e.f.a
    public int getDefaultType() {
        return super.getDefaultType();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.b.b.e.f.a
    public String getName() {
        return "android_custom_offline_web_cache";
    }
}
