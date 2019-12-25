package com.baidu.tbadk.switchs;
/* loaded from: classes.dex */
public class DuiSwitch extends BaseNormalSwitch {
    private static DuiSwitch mInstance = new DuiSwitch();

    public static boolean getInOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "dui_switch";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, com.baidu.adp.lib.featureSwitch.a
    public int getDefaultType() {
        return super.getDefaultType();
    }
}
