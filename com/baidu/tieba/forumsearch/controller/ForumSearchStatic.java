package com.baidu.tieba.forumsearch.controller;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
/* loaded from: classes3.dex */
public class ForumSearchStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumSearchActivityConfig.class, ForumSearchActivity.class);
        Vb();
    }

    private static void Vb() {
        com.baidu.tieba.tbadkCore.a.a.c(309466, SearchPostForumSocketResponseMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(309466, CmdConfigHttp.CMD_SEARCH_POST_FORUM, TbConfig.SEARCH_POST_FORUM, SearchPostForumHttpResponseMessage.class, false, false, true, false);
    }
}
