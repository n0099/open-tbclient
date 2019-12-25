package com.baidu.tbadk.switchs;
/* loaded from: classes.dex */
public class FrsHeadVideoAutoPlaySwitch extends BaseNormalSwitch {
    private static final FrsHeadVideoAutoPlaySwitch mInstance = new FrsHeadVideoAutoPlaySwitch();

    public static boolean getIsOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "is_auto_play_forumheadvideo";
    }
}
