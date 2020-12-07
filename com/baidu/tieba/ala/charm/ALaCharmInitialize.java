package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.d.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes4.dex */
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
                    if (aVar.bqR != null && aVar.bqR.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bqR.context);
                        if (aVar.bqR.bqT != null && aVar.bqR.bqT.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a Hj = new com.baidu.tieba.ala.charm.a.a(tbPageContext).Hi(String.valueOf(aVar.bqR.bqT.mLiveInfo.group_id)).Hj(String.valueOf(aVar.bqR.bqT.mLiveInfo.live_id));
                            if (aVar.bqR.bqT.aJV != null) {
                                Hj.Hl(String.valueOf(aVar.bqR.bqT.aJV.charmCount)).Hk(String.valueOf(String.valueOf(aVar.bqR.bqT.aJV.userId)));
                            }
                            aVar.a(Hj);
                        }
                    }
                }
            }
        });
    }
}
