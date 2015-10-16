package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class MoplusSwitchStatic extends a {
    public static final String[] azd;

    static {
        e.gv().e(MoplusSwitchStatic.class);
        azd = new String[]{"com.baidu.hello", "com.baidu.android.moplusmanager", "com.baidu.android.moplus"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_moplus";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return azd;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    public static boolean Er() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(false)) {
            return TbadkSettings.getInst().loadInt(new StringBuilder("moplus_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= TbadkCoreApplication.m411getInst().getFeatureCrashAutoCloseLimit() && e.gv().ah("android_moplus") == 1;
        }
        return false;
    }
}
