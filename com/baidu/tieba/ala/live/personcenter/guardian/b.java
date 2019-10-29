package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes6.dex */
public class b extends IntentConfig {
    public b(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("charm_value", str2);
        getIntent().putExtra("user_id", str);
    }
}
