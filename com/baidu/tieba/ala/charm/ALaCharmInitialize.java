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
                    if (aVar.brA != null && aVar.brA.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.brA.context);
                        if (aVar.brA.brC != null && aVar.brA.brC.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a Gw = new com.baidu.tieba.ala.charm.a.a(tbPageContext).Gv(String.valueOf(aVar.brA.brC.mLiveInfo.group_id)).Gw(String.valueOf(aVar.brA.brC.mLiveInfo.live_id));
                            if (aVar.brA.brC.aId != null) {
                                Gw.Gy(String.valueOf(aVar.brA.brC.aId.charmCount)).Gx(String.valueOf(String.valueOf(aVar.brA.brC.aId.userId)));
                            }
                            aVar.a(Gw);
                        }
                    }
                }
            }
        });
    }
}
