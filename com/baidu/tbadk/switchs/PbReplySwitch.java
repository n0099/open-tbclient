package com.baidu.tbadk.switchs;
/* loaded from: classes2.dex */
public class PbReplySwitch extends BaseNormalSwitch {
    private static PbReplySwitch mInstance = new PbReplySwitch();

    public static boolean getInOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "pb_reply_switch";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    public int getDefaultType() {
        return super.getDefaultType();
    }
}
