package com.baidu.tieba.forumsearch.controller;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumsearch.message.SearchPostForumHttpResponseMessage;
import com.baidu.tieba.forumsearch.message.SearchPostForumSocketResponseMessage;
import d.b.i0.c3.d0.a;
/* loaded from: classes4.dex */
public class ForumSearchStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumSearchActivityConfig.class, ForumSearchActivity.class);
        a();
    }

    public static void a() {
        a.f(309466, SearchPostForumSocketResponseMessage.class, false);
        a.c(309466, CmdConfigHttp.CMD_SEARCH_POST_FORUM, TbConfig.SEARCH_POST_FORUM, SearchPostForumHttpResponseMessage.class, false, false, true, false);
    }
}
