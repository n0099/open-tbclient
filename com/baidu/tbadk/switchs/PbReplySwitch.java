package com.baidu.tbadk.switchs;
/* loaded from: classes3.dex */
public class PbReplySwitch extends BaseNormalSwitch {
    public static PbReplySwitch mInstance = new PbReplySwitch();

    public static boolean getInOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.b.b.e.f.a
    public int getDefaultType() {
        return super.getDefaultType();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.b.b.e.f.a
    public String getName() {
        return "pb_reply_switch";
    }
}
