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
                    if (aVar.bgQ != null && aVar.bgQ.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.bgQ.context);
                        if (aVar.bgQ.bgS != null && aVar.bgQ.bgS.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a Fw = new com.baidu.tieba.ala.charm.a.a(tbPageContext).Fv(String.valueOf(aVar.bgQ.bgS.mLiveInfo.group_id)).Fw(String.valueOf(aVar.bgQ.bgS.mLiveInfo.live_id));
                            if (aVar.bgQ.bgS.aEz != null) {
                                Fw.Fy(String.valueOf(aVar.bgQ.bgS.aEz.charmCount)).Fx(String.valueOf(String.valueOf(aVar.bgQ.bgS.aEz.userId)));
                            }
                            aVar.a(Fw);
                        }
                    }
                }
            }
        });
    }
}
