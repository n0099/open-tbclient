package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialHistoryImageActivity;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.mygroup.PersonGroupActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* loaded from: classes3.dex */
public class TiebaIMActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(GroupChatActivityConfig.class, GroupChatActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialMsgImageActivityConfig.class, OfficialMsgImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialBarHistoryActivityConfig.class, OfficialBarHistoryActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialHistoryImageActivityConfig.class, OfficialHistoryImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(AddGroupActivityConfig.class, AddGroupActivity.class);
        aFK();
    }

    private static void aFK() {
        az.zV().a(new az.a() { // from class: com.baidu.tieba.im.TiebaIMActivityStatic.1
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (UtilHelper.parsePushMidPageUrl(lowerCase, sb, sb2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016486));
                    tbPageContext.sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(sb.toString(), sb2.toString(), "push")));
                    return 0;
                }
                return 3;
            }
        });
    }
}
