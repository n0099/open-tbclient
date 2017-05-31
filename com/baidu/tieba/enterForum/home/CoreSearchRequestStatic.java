package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* loaded from: classes.dex */
public class CoreSearchRequestStatic {
    private static EnterForumModel bMq;

    static {
        Xf();
    }

    private static void Xf() {
        com.baidu.tieba.tbadkCore.d.c.biy();
        if (bMq == null) {
            bMq = new EnterForumModel(null);
            bMq.a(new a());
        }
        MessageManager.getInstance().registerListener(new b(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011));
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE));
    }
}
