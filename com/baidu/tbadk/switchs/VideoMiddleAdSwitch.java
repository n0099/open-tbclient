package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import d.a.c.e.f.a;
@ModifyClass
/* loaded from: classes3.dex */
public class VideoMiddleAdSwitch extends a {
    public static final String KEY_SWITCH = "video_bear_flow_switch";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

    @Modify(description = "视频中间页插入小熊广告开关")
    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY_SWITCH) == 1;
    }

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.a.c.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.a.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.a.c.e.f.a
    public String getName() {
        return KEY_SWITCH;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
