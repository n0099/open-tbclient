package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad;
/* loaded from: classes3.dex */
public class FrsMemberStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumMemberActivityConfig.class, ForumMemberActivity.class);
        ad.awn().mZ(3);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new i(null, j.dBv));
                    absDelegateAdapterList.add(new l(null, m.dBJ));
                    absDelegateAdapterList.add(new g(null, com.baidu.tieba.frs.h.dDZ));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.a(null, com.baidu.tieba.forumMember.a.b.dAZ));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.d(null, com.baidu.tieba.forumMember.a.e.dBc));
                    absDelegateAdapterList.add(new o(null, p.dCc));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003011) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof ac)) {
                    ac acVar = (ac) customResponsedMessage.getData();
                    e eVar = new e();
                    eVar.setTag(acVar.bIy);
                    acVar.a(3, eVar);
                }
            }
        });
    }
}
