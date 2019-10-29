package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
/* loaded from: classes3.dex */
public class SearchFriendActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        MessageManager.getInstance().registerTask(new CustomMessageTask(CmdConfigCustom.CMD_GET_OFFICIAL_ACCOUNT, new com.baidu.tieba.addresslist.im.searchfriend.a.a()));
    }
}
