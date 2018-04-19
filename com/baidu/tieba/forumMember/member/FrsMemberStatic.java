package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
/* loaded from: classes3.dex */
public class FrsMemberStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumMemberActivityConfig.class, ForumMemberActivity.class);
        z.aqG().km(3);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new i(null, j.cUh));
                    absDelegateAdapterList.add(new l(null, m.cUv));
                    absDelegateAdapterList.add(new g(null, com.baidu.tieba.frs.g.cWV));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.a(null, com.baidu.tieba.forumMember.a.b.cTL));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.a.d(null, com.baidu.tieba.forumMember.a.e.cTO));
                    absDelegateAdapterList.add(new o(null, p.cUO));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003011) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof y)) {
                    y yVar = (y) customResponsedMessage.getData();
                    e eVar = new e();
                    eVar.setTag(yVar.aTr);
                    yVar.a(3, eVar);
                }
            }
        });
    }
}
