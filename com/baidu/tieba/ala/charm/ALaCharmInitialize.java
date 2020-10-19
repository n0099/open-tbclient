package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.b.u;
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
                    if (aVar.bkG != null && aVar.bkG.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bkG.context);
                        if (aVar.bkG.bkI != null && aVar.bkG.bkI.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a Gh = new com.baidu.tieba.ala.charm.a.a(tbPageContext).Gg(String.valueOf(aVar.bkG.bkI.mLiveInfo.group_id)).Gh(String.valueOf(aVar.bkG.bkI.mLiveInfo.live_id));
                            if (aVar.bkG.bkI.aHD != null) {
                                Gh.Gj(String.valueOf(aVar.bkG.bkI.aHD.charmCount)).Gi(String.valueOf(String.valueOf(aVar.bkG.bkI.aHD.userId)));
                            }
                            aVar.a(Gh);
                        }
                    }
                }
            }
        });
    }
}
