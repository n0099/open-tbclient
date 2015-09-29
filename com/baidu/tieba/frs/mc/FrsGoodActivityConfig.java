package com.baidu.tieba.frs.mc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FrsGoodActivityConfig extends IntentConfig {
    public FrsGoodActivityConfig(Context context) {
        super(context);
    }

    public FrsGoodActivityConfig createNormalCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, false);
    }

    public FrsGoodActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", z);
        intent.putExtra(FrsActivityConfig.GOOD, z2);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }
}
