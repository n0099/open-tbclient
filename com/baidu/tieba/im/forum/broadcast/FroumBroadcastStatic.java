package com.baidu.tieba.im.forum.broadcast;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumBroadCastMajorHistoryActivityConfig;
/* loaded from: classes4.dex */
public class FroumBroadcastStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumBroadCastMajorHistoryActivityConfig.class, ForumBroadCastMajorHistoryActivity.class);
    }
}
