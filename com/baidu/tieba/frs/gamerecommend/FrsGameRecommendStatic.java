package com.baidu.tieba.frs.gamerecommend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.ad;
/* loaded from: classes3.dex */
public class FrsGameRecommendStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ad) {
                        ad adVar = (ad) data;
                        adVar.b(new a(adVar.getForumId(), adVar.getForumName()));
                    }
                }
            }
        });
    }
}
