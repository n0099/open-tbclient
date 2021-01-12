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
                    if (aVar.bnZ != null && aVar.bnZ.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bnZ.context);
                        if (aVar.bnZ.bob != null && aVar.bnZ.bob.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a FW = new com.baidu.tieba.ala.charm.a.a(tbPageContext).FV(String.valueOf(aVar.bnZ.bob.mLiveInfo.group_id)).FW(String.valueOf(aVar.bnZ.bob.mLiveInfo.live_id));
                            if (aVar.bnZ.bob.aFH != null) {
                                FW.FY(String.valueOf(aVar.bnZ.bob.aFH.charmCount)).FX(String.valueOf(String.valueOf(aVar.bnZ.bob.aFH.userId)));
                            }
                            aVar.a(FW);
                        }
                    }
                }
            }
        });
    }
}
