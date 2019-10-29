package com.baidu.tieba.ala.live.personcenter.fans;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes6.dex */
public class e extends IntentConfig {
    public e(Context context, boolean z, String str, int i) {
        super(context);
        getIntent().putExtra("follow", z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_sex", i);
    }
}
