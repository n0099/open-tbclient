package com.baidu.tieba.ala.charm;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
/* loaded from: classes3.dex */
public class ALaCharmInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaCharmCardActivityConfig.class, ALaCharmCardActivity.class);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.charm.ALaCharmInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.avW != null && aVar.avW.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.avW.context);
                        if (aVar.avW.avY != null && aVar.avW.avY.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a ya = new com.baidu.tieba.ala.charm.a.a(tbPageContext).xZ(String.valueOf(aVar.avW.avY.mLiveInfo.group_id)).ya(String.valueOf(aVar.avW.avY.mLiveInfo.live_id));
                            if (aVar.avW.avY.XQ != null) {
                                ya.yc(String.valueOf(aVar.avW.avY.XQ.charmCount)).yb(String.valueOf(String.valueOf(aVar.avW.avY.XQ.userId)));
                            }
                            aVar.a(ya);
                        }
                    }
                }
            }
        });
    }
}
