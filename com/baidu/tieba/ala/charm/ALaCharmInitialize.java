package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes2.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.c.a)) {
                    com.baidu.live.liveroom.c.a aVar = (com.baidu.live.liveroom.c.a) customResponsedMessage.getData();
                    if (aVar.arj != null && aVar.arj.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.arj.context);
                        if (aVar.arj.arl != null && aVar.arj.arl.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a xB = new com.baidu.tieba.ala.charm.a.a(tbPageContext).xA(String.valueOf(aVar.arj.arl.mLiveInfo.group_id)).xB(String.valueOf(aVar.arj.arl.mLiveInfo.live_id));
                            if (aVar.arj.arl.VP != null) {
                                xB.xD(String.valueOf(aVar.arj.arl.VP.charmCount)).xC(String.valueOf(String.valueOf(aVar.arj.arl.VP.userId)));
                            }
                            aVar.a(xB);
                        }
                    }
                }
            }
        });
    }
}
