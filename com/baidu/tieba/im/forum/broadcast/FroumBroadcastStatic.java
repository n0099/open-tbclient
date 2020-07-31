package com.baidu.tieba.im.forum.broadcast;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumBroadCastMajorHistoryActivityConfig;
/* loaded from: classes20.dex */
public class FroumBroadcastStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumBroadCastMajorHistoryActivityConfig.class, ForumBroadCastMajorHistoryActivity.class);
    }
}
