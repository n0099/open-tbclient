package com.baidu.tbadk.switchs;

import com.baidu.tbadk.TbSingleton;
import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class BenchmarkSwitch extends a {
    public static final String ANDROID_BENCHMARK_SWITCH = "android_benchmark_switch";
    public static final int DEFAULT_TYPE = 1;
    public static final int OFF_TYPE = 0;

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
        TbSingleton.getInstance().setEnableBenchmark(i2 != 0);
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
        return ANDROID_BENCHMARK_SWITCH;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
