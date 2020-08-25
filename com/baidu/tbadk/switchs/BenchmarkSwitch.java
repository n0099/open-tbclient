package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.tbadk.TbSingleton;
/* loaded from: classes2.dex */
public class BenchmarkSwitch extends a {
    public static final String ANDROID_BENCHMARK_SWITCH = "android_benchmark_switch";
    public static final int DEFAULT_TYPE = 1;
    public static final int OFF_TYPE = 0;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
        TbSingleton.getInstance().setEnableBenchmark(i != 0);
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return ANDROID_BENCHMARK_SWITCH;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
