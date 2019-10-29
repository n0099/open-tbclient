package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import com.baidu.ala.atomdata.AlaPersonCenterExpActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes6.dex */
public class a extends IntentConfig {
    public a(Context context, long j, int i) {
        super(context);
        getIntent().putExtra(AlaPersonCenterExpActivityConfig.CURRENT_EXP, j);
        getIntent().putExtra("current_level", i);
        getIntent().putExtra(AlaPersonCenterExpActivityConfig.IS_HOST, true);
    }
}
