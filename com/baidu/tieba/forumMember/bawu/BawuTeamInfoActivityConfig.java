package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes4.dex */
public class BawuTeamInfoActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";

    public BawuTeamInfoActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("forum_id", j);
    }
}
