package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import d.a.n0.s.e.b.b.a;
/* loaded from: classes4.dex */
public class SearchFriendActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        MessageManager.getInstance().registerTask(new CustomMessageTask(2001265, new a()));
    }
}
