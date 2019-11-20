package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
/* loaded from: classes.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.IM_DELETE_IM_DB) { // from class: com.baidu.tieba.im.db.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008015 && customResponsedMessage.getData() != null) {
                    z.b(new y<Void>() { // from class: com.baidu.tieba.im.db.Static.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.y
                        /* renamed from: aEe */
                        public Void doInBackground() {
                            if (customResponsedMessage.getData() instanceof String) {
                                g.xN((String) customResponsedMessage.getData());
                                return null;
                            }
                            return null;
                        }
                    }, new com.baidu.tbadk.util.j<Void>() { // from class: com.baidu.tieba.im.db.Static.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.j
                        /* renamed from: a */
                        public void onReturnDataInUI(Void r4) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_CLEAR_MSG));
                        }
                    });
                }
            }
        });
    }
}
