package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.b.c.e.f.a;
import d.b.h0.r.d0.b;
/* loaded from: classes3.dex */
public class PicReqSwitch extends a {
    public static final String PIC_REQ_SWITCH_KEY = "pic_req_switch_key";

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(PIC_REQ_SWITCH_KEY) == 1;
    }

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.c.e.f.a
    public int getDefaultType() {
        return b.j().k("key_pic_req_switch", 0);
    }

    @Override // d.b.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.c.e.f.a
    public String getName() {
        return PIC_REQ_SWITCH_KEY;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
