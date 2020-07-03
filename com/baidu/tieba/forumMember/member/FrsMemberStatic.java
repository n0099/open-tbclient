package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ah;
/* loaded from: classes10.dex */
public class FrsMemberStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumMemberActivityConfig.class, ForumMemberActivity.class);
        ah.bZY().uM(3);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new i(null, j.hwa));
                    absDelegateAdapterList.add(new l(null, m.hwl));
                    absDelegateAdapterList.add(new g(null, com.baidu.tieba.frs.m.hzt));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.a(null, com.baidu.tieba.forumMember.a.b.hvD));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.d(null, com.baidu.tieba.forumMember.a.e.hvG));
                    absDelegateAdapterList.add(new o(null, p.hwB));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_MODEL) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof ag)) {
                    ag agVar = (ag) customResponsedMessage.getData();
                    e eVar = new e();
                    eVar.setTag(agVar.eyE);
                    agVar.a(3, eVar);
                }
            }
        });
    }
}
