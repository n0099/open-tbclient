package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes4.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(u.class, CharmRankTotalActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.aYG != null && aVar.aYG.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.aYG.context);
                        if (aVar.aYG.aYI != null && aVar.aYG.aYI.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a CC = new com.baidu.tieba.ala.charm.a.a(tbPageContext).CB(String.valueOf(aVar.aYG.aYI.mLiveInfo.group_id)).CC(String.valueOf(aVar.aYG.aYI.mLiveInfo.live_id));
                            if (aVar.aYG.aYI.ayC != null) {
                                CC.CE(String.valueOf(aVar.aYG.aYI.ayC.charmCount)).CD(String.valueOf(String.valueOf(aVar.aYG.aYI.ayC.userId)));
                            }
                            aVar.a(CC);
                        }
                    }
                }
            }
        });
    }
}
