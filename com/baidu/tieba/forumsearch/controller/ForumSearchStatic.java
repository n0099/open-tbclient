package com.baidu.tieba.forumsearch.controller;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
/* loaded from: classes7.dex */
public class ForumSearchStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumSearchActivityConfig.class, ForumSearchActivity.class);
        bQw();
    }

    private static void bQw() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_SEARCH_POST_FORUM, SearchPostForumSocketResponseMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SEARCH_POST_FORUM, 1003335, TbConfig.SEARCH_POST_FORUM, SearchPostForumHttpResponseMessage.class, false, false, true, false);
    }
}
