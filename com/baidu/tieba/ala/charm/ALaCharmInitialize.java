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
                    if (aVar.aVZ != null && aVar.aVZ.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.aVZ.context);
                        if (aVar.aVZ.aWb != null && aVar.aVZ.aWb.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a Bt = new com.baidu.tieba.ala.charm.a.a(tbPageContext).Bs(String.valueOf(aVar.aVZ.aWb.mLiveInfo.group_id)).Bt(String.valueOf(aVar.aVZ.aWb.mLiveInfo.live_id));
                            if (aVar.aVZ.aWb.avj != null) {
                                Bt.Bv(String.valueOf(aVar.aVZ.aWb.avj.charmCount)).Bu(String.valueOf(String.valueOf(aVar.aVZ.aWb.avj.userId)));
                            }
                            aVar.a(Bt);
                        }
                    }
                }
            }
        });
    }
}
