package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes2.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.c.a)) {
                    com.baidu.live.liveroom.c.a aVar = (com.baidu.live.liveroom.c.a) customResponsedMessage.getData();
                    if (aVar.arV != null && aVar.arV.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.arV.context);
                        if (aVar.arV.arX != null && aVar.arV.arX.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a xG = new com.baidu.tieba.ala.charm.a.a(tbPageContext).xF(String.valueOf(aVar.arV.arX.mLiveInfo.group_id)).xG(String.valueOf(aVar.arV.arX.mLiveInfo.live_id));
                            if (aVar.arV.arX.Wf != null) {
                                xG.xI(String.valueOf(aVar.arV.arX.Wf.charmCount)).xH(String.valueOf(String.valueOf(aVar.arV.arX.Wf.userId)));
                            }
                            aVar.a(xG);
                        }
                    }
                }
            }
        });
    }
}
