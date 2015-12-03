package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class SearchFriendActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(SearchFriendActivityConfig.class, SearchFriendActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_REQUEST_RECOMMEND_READ_CACHE, new com.baidu.tieba.addresslist.im.searchfriend.cache.b());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_REQUEST_RECOMMEND_WRITE_CACHE, new com.baidu.tieba.addresslist.im.searchfriend.cache.c());
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_GET_OFFICIAL_ACCOUNT, new com.baidu.tieba.addresslist.im.searchfriend.cache.a());
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }
}
