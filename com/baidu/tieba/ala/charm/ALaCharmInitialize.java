package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes11.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(x.class, CharmRankTotalActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.bsL != null && aVar.bsL.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bsL.context);
                        if (aVar.bsL.bsN != null && aVar.bsL.bsN.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a Hi = new com.baidu.tieba.ala.charm.a.a(tbPageContext).Hh(String.valueOf(aVar.bsL.bsN.mLiveInfo.group_id)).Hi(String.valueOf(aVar.bsL.bsN.mLiveInfo.live_id));
                            if (aVar.bsL.bsN.aKu != null) {
                                Hi.Hk(String.valueOf(aVar.bsL.bsN.aKu.charmCount)).Hj(String.valueOf(String.valueOf(aVar.bsL.bsN.aKu.userId)));
                            }
                            aVar.a(Hi);
                        }
                    }
                }
            }
        });
    }
}
