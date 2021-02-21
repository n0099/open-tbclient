package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
/* loaded from: classes8.dex */
public class FrsMemberStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumMemberActivityConfig.class, ForumMemberActivity.class);
        af.cEG().yZ(3);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new g(null, h.jcJ));
                    absDelegateAdapterList.add(new i(null, j.jcU));
                    absDelegateAdapterList.add(new f(null, com.baidu.tieba.frs.n.jge));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.manito.a(null, com.baidu.tieba.forumMember.manito.b.jcm));
                    absDelegateAdapterList.add(new com.baidu.tieba.forumMember.manito.c(null, com.baidu.tieba.forumMember.manito.d.jcp));
                    absDelegateAdapterList.add(new k(null, l.jdl));
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_MODEL) { // from class: com.baidu.tieba.forumMember.member.FrsMemberStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof ae)) {
                    ae aeVar = (ae) customResponsedMessage.getData();
                    d dVar = new d();
                    dVar.setTag(aeVar.fGZ);
                    aeVar.a(3, dVar);
                }
            }
        });
    }
}
