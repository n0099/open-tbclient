package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class CoreSearchRequestStatic {
    private static com.baidu.tieba.enterForum.c.c bvi;

    static {
        SD();
    }

    private static void SD() {
        com.baidu.tieba.tbadkCore.d.c.bfY();
        if (bvi == null) {
            bvi = new com.baidu.tieba.enterForum.c.c(null);
            bvi.a(new a());
        }
        MessageManager.getInstance().registerListener(new b(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011));
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE));
    }
}
