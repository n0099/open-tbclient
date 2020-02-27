package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.z;
/* loaded from: classes10.dex */
public class FrsMemberStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumMemberActivityConfig.class, ForumMemberActivity.class);
        aa.bFC().ta(3);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new i(null, j.gkM));
                    absDelegateAdapterList.add(new l(null, m.gkY));
                    absDelegateAdapterList.add(new g(null, com.baidu.tieba.frs.j.gnT));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.a(null, com.baidu.tieba.forumMember.a.b.gko));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.d(null, com.baidu.tieba.forumMember.a.e.gkr));
                    absDelegateAdapterList.add(new o(null, p.glo));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_MODEL) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof z)) {
                    z zVar = (z) customResponsedMessage.getData();
                    e eVar = new e();
                    eVar.setTag(zVar.dBj);
                    zVar.a(3, eVar);
                }
            }
        });
    }
}
