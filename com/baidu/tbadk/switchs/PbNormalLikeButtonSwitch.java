package com.baidu.tbadk.switchs;
/* loaded from: classes2.dex */
public class PbNormalLikeButtonSwitch extends BaseNormalSwitch {
    private static final PbNormalLikeButtonSwitch mInstance = new PbNormalLikeButtonSwitch();
    private final String SWITCH_NAME = "android_pb_normal_like_btn";

    public static boolean getIsOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "android_pb_normal_like_btn";
    }
}
