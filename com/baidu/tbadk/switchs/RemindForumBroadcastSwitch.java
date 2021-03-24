package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class RemindForumBroadcastSwitch extends a {
    public static final String KEY = "forum_mask_stat";
    public static final int TYPE_OFF = 0;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return KEY;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
