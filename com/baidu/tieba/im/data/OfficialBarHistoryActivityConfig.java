package com.baidu.tieba.im.data;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes4.dex */
public class OfficialBarHistoryActivityConfig extends IntentConfig {
    public OfficialBarHistoryActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra("forum_id", i2);
    }
}
