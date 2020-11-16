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
                    if (aVar.blK != null && aVar.blK.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.blK.context);
                        if (aVar.blK.blM != null && aVar.blK.blM.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a Gv = new com.baidu.tieba.ala.charm.a.a(tbPageContext).Gu(String.valueOf(aVar.blK.blM.mLiveInfo.group_id)).Gv(String.valueOf(aVar.blK.blM.mLiveInfo.live_id));
                            if (aVar.blK.blM.aHk != null) {
                                Gv.Gx(String.valueOf(aVar.blK.blM.aHk.charmCount)).Gw(String.valueOf(String.valueOf(aVar.blK.blM.aHk.userId)));
                            }
                            aVar.a(Gv);
                        }
                    }
                }
            }
        });
    }
}
