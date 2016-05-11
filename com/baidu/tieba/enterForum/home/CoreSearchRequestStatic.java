package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class CoreSearchRequestStatic {
    private static com.baidu.tieba.enterForum.c.c aWW;

    static {
        Mp();
    }

    private static void Mp() {
        com.baidu.tieba.tbadkCore.d.c.aUp();
        if (aWW == null) {
            aWW = new com.baidu.tieba.enterForum.c.c(null);
            aWW.a(new a());
        }
        MessageManager.getInstance().registerListener(new b(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011));
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_REQUEST_ENTER_FORUM_MESSAGE));
    }
}
