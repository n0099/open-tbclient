package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes6.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.c.a)) {
                    com.baidu.live.liveroom.c.a aVar = (com.baidu.live.liveroom.c.a) customResponsedMessage.getData();
                    if (aVar.ajm != null && aVar.ajm.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.ajm.context);
                        if (aVar.ajm.ajo != null && aVar.ajm.ajo.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a sT = new com.baidu.tieba.ala.charm.a.a(tbPageContext).sS(String.valueOf(aVar.ajm.ajo.mLiveInfo.group_id)).sT(String.valueOf(aVar.ajm.ajo.mLiveInfo.live_id));
                            if (aVar.ajm.ajo.OR != null) {
                                sT.sV(String.valueOf(aVar.ajm.ajo.OR.charmCount)).sU(String.valueOf(String.valueOf(aVar.ajm.ajo.OR.userId)));
                            }
                            aVar.a(sT);
                        }
                    }
                }
            }
        });
    }
}
