package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.b.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes4.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(w.class, CharmRankTotalActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.bmb != null && aVar.bmb.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bmb.context);
                        if (aVar.bmb.bmd != null && aVar.bmb.bmd.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a GG = new com.baidu.tieba.ala.charm.a.a(tbPageContext).GF(String.valueOf(aVar.bmb.bmd.mLiveInfo.group_id)).GG(String.valueOf(aVar.bmb.bmd.mLiveInfo.live_id));
                            if (aVar.bmb.bmd.aIe != null) {
                                GG.GI(String.valueOf(aVar.bmb.bmd.aIe.charmCount)).GH(String.valueOf(String.valueOf(aVar.bmb.bmd.aIe.userId)));
                            }
                            aVar.a(GG);
                        }
                    }
                }
            }
        });
    }
}
