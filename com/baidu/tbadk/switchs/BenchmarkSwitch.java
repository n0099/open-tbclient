package com.baidu.tbadk.switchs;

import com.baidu.tbadk.TbSingleton;
import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class BenchmarkSwitch extends a {
    public static final String ANDROID_BENCHMARK_SWITCH = "android_benchmark_switch";
    public static final int DEFAULT_TYPE = 1;
    public static final int OFF_TYPE = 0;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
        TbSingleton.getInstance().setEnableBenchmark(i != 0);
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return ANDROID_BENCHMARK_SWITCH;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
