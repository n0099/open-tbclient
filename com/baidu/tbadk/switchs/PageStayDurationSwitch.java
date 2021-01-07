package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.tbadk.m.e;
/* loaded from: classes.dex */
public class PageStayDurationSwitch extends a {
    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
        e.bHt().setSamllFlowOpen(1 == i);
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "log_online_smallflow";
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
