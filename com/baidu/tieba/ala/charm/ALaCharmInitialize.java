package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes7.dex */
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
                    if (aVar.bdX != null && aVar.bdX.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bdX.context);
                        if (aVar.bdX.bdZ != null && aVar.bdX.bdZ.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a EX = new com.baidu.tieba.ala.charm.a.a(tbPageContext).EW(String.valueOf(aVar.bdX.bdZ.mLiveInfo.group_id)).EX(String.valueOf(aVar.bdX.bdZ.mLiveInfo.live_id));
                            if (aVar.bdX.bdZ.aDE != null) {
                                EX.EZ(String.valueOf(aVar.bdX.bdZ.aDE.charmCount)).EY(String.valueOf(String.valueOf(aVar.bdX.bdZ.aDE.userId)));
                            }
                            aVar.a(EX);
                        }
                    }
                }
            }
        });
    }
}
