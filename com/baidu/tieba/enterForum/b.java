package com.baidu.tieba.enterForum;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
/* loaded from: classes9.dex */
public class b {
    public static void b(TbPageContext<?> tbPageContext, String str) {
        ForumSquareActivityConfig forumSquareActivityConfig;
        if (tbPageContext != null) {
            if (!StringUtils.isNull(str)) {
                forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity(), str);
            } else {
                forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity());
            }
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSquareActivityConfig));
        }
    }
}
