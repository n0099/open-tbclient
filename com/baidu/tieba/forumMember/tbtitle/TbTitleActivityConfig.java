package com.baidu.tieba.forumMember.tbtitle;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes8.dex */
public class TbTitleActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forumId";
    public static final String FORUM_NAME = "forumName";

    public TbTitleActivityConfig(Context context, String str, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(FORUM_NAME, str);
        intent.putExtra(FORUM_ID, str2);
    }
}
