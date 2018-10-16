package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2008015) { // from class: com.baidu.tieba.im.db.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008015 && customResponsedMessage.getData() != null) {
                    x.b(new w<Void>() { // from class: com.baidu.tieba.im.db.Static.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.w
                        /* renamed from: Vh */
                        public Void doInBackground() {
                            if (customResponsedMessage.getData() instanceof String) {
                                g.pv((String) customResponsedMessage.getData());
                                return null;
                            }
                            return null;
                        }
                    }, new com.baidu.tbadk.util.h<Void>() { // from class: com.baidu.tieba.im.db.Static.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.h
                        /* renamed from: b */
                        public void onReturnDataInUI(Void r4) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008016));
                        }
                    });
                }
            }
        });
    }
}
