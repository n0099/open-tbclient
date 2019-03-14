package com.baidu.tieba.frs.gamerecommend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.ab;
/* loaded from: classes4.dex */
public class FrsGameRecommendStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ab) {
                        ab abVar = (ab) data;
                        abVar.b(new a(abVar.getForumId(), abVar.getForumName()));
                    }
                }
            }
        });
    }
}
