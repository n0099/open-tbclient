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
                    if (aVar.awh != null && aVar.awh.context != null) {
                        TbPageContext tbPageContext = (TbPageContext) IScrollableHelper.getBbPageContext(aVar.awh.context);
                        if (aVar.awh.awj != null && aVar.awh.awj.mLiveInfo != null) {
                            com.baidu.tieba.ala.charm.a.a yc = new com.baidu.tieba.ala.charm.a.a(tbPageContext).yb(String.valueOf(aVar.awh.awj.mLiveInfo.group_id)).yc(String.valueOf(aVar.awh.awj.mLiveInfo.live_id));
                            if (aVar.awh.awj.Ya != null) {
                                yc.ye(String.valueOf(aVar.awh.awj.Ya.charmCount)).yd(String.valueOf(String.valueOf(aVar.awh.awj.Ya.userId)));
                            }
                            aVar.a(yc);
                        }
                    }
                }
            }
        });
    }
}
