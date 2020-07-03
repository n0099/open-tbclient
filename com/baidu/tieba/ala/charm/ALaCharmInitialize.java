package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.t;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes3.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(t.class, CharmRankTotalActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.aYI != null && aVar.aYI.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.aYI.context);
                        if (aVar.aYI.aYK != null && aVar.aYI.aYK.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a BR = new com.baidu.tieba.ala.charm.a.a(tbPageContext).BQ(String.valueOf(aVar.aYI.aYK.mLiveInfo.group_id)).BR(String.valueOf(aVar.aYI.aYK.mLiveInfo.live_id));
                            if (aVar.aYI.aYK.axp != null) {
                                BR.BT(String.valueOf(aVar.aYI.aYK.axp.charmCount)).BS(String.valueOf(String.valueOf(aVar.aYI.aYK.axp.userId)));
                            }
                            aVar.a(BR);
                        }
                    }
                }
            }
        });
    }
}
