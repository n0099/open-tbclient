package com.baidu.tieba.friendFeed;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tieba.friendFeed.message.ResponseFriendFeedMessage;
/* loaded from: classes.dex */
public class FriendFeedActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(FriendFeedActivityConfig.class, FriendFeedActivity.class);
        com.baidu.tieba.tbadkCore.a.a.a(303003, ResponseFriendFeedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001172, com.baidu.tieba.friendFeed.message.a.a.class);
        com.baidu.tieba.tbadkCore.location.e.anh();
    }
}
