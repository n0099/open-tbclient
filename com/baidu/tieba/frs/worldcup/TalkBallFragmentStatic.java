package com.baidu.tieba.frs.worldcup;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ab;
/* loaded from: classes2.dex */
public class TalkBallFragmentStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.worldcup.TalkBallFragmentStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ab) {
                        a aVar = new a();
                        aVar.Jb().type = 12;
                        aVar.Jb().aQQ = d.k.frs_tab_talkball;
                        aVar.a((ab) data);
                    }
                }
            }
        });
    }
}
