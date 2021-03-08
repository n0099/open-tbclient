package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes10.dex */
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
                    if (aVar.bta != null && aVar.bta.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bta.context);
                        if (aVar.bta.btc != null && aVar.bta.btc.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a GF = new com.baidu.tieba.ala.charm.a.a(tbPageContext).GE(String.valueOf(aVar.bta.btc.mLiveInfo.group_id)).GF(String.valueOf(aVar.bta.btc.mLiveInfo.live_id));
                            if (aVar.bta.btc.aJD != null) {
                                GF.GH(String.valueOf(aVar.bta.btc.aJD.charmCount)).GG(String.valueOf(String.valueOf(aVar.bta.btc.aJD.userId)));
                            }
                            aVar.a(GF);
                        }
                    }
                }
            }
        });
    }
}
