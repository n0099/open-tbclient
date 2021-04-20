package com.baidu.tbadk.switchs;
/* loaded from: classes3.dex */
public class DuiSwitch extends BaseNormalSwitch {
    public static DuiSwitch mInstance = new DuiSwitch();

    public static boolean getInOn() {
        return mInstance.isOn();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.b.c.e.f.a
    public int getDefaultType() {
        return super.getDefaultType();
    }

    @Override // com.baidu.tbadk.switchs.BaseNormalSwitch, d.b.c.e.f.a
    public String getName() {
        return "dui_switch";
    }
}
