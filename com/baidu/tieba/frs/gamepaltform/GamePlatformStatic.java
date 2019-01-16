package com.baidu.tieba.frs.gamepaltform;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes3.dex */
public class GamePlatformStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.gamepaltform.GamePlatformStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new a(null, com.baidu.tieba.h.b.eoi, null));
                }
            }
        });
    }
}
