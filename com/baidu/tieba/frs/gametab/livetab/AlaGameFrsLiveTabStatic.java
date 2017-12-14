package com.baidu.tieba.frs.gametab.livetab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.af;
/* loaded from: classes.dex */
public class AlaGameFrsLiveTabStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.livetab.AlaGameFrsLiveTabStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof af) {
                        af afVar = (af) data;
                        c cVar = new c();
                        cVar.setForumId(afVar.getForumId());
                        cVar.setForumName(afVar.getForumName());
                        cVar.setForumGameLabel(afVar.getForumGameLabel());
                        cVar.a(afVar);
                    }
                }
            }
        });
    }
}
