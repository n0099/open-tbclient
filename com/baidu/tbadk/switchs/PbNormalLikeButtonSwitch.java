package com.baidu.tbadk.switchs;
/* loaded from: classes3.dex */
public class PbNormalLikeButtonSwitch extends BaseNormalSwitch {
    public static final PbNormalLikeButtonSwitch mInstance = new PbNormalLikeButtonSwitch();
    public final String SWITCH_NAME = "android_pb_normal_like_btn";

    public static boolean getIsOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.b.b.e.f.a
    public String getName() {
        return "android_pb_normal_like_btn";
    }
}
