package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.s;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes3.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(s.class, CharmRankTotalActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.aPK != null && aVar.aPK.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.aPK.context);
                        if (aVar.aPK.aPM != null && aVar.aPK.aPM.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a zJ = new com.baidu.tieba.ala.charm.a.a(tbPageContext).zI(String.valueOf(aVar.aPK.aPM.mLiveInfo.group_id)).zJ(String.valueOf(aVar.aPK.aPM.mLiveInfo.live_id));
                            if (aVar.aPK.aPM.aqe != null) {
                                zJ.zL(String.valueOf(aVar.aPK.aPM.aqe.charmCount)).zK(String.valueOf(String.valueOf(aVar.aPK.aPM.aqe.userId)));
                            }
                            aVar.a(zJ);
                        }
                    }
                }
            }
        });
    }
}
