package com.baidu.tbadk.switchs;
/* loaded from: classes3.dex */
public class FrsHeadVideoAutoPlaySwitch extends BaseNormalSwitch {
    public static final FrsHeadVideoAutoPlaySwitch mInstance = new FrsHeadVideoAutoPlaySwitch();

    public static boolean getIsOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.a.c.e.f.a
    public String getName() {
        return "is_auto_play_forumheadvideo";
    }
}
