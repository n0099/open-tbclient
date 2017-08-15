package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a cUs;
    public BdUniqueId aON;
    public int cUq = -1;
    public boolean cUr = false;
    private CustomMessageListener aqh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.cUr = true;
                }
            }
        }
    };

    public static synchronized a aoX() {
        a aVar;
        synchronized (a.class) {
            if (cUs == null) {
                cUs = new a();
            }
            aVar = cUs;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aON != null) {
            MessageManager.getInstance().unRegisterListener(this.aON);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aON = bdUniqueId;
            this.aqh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aqh);
        }
    }
}
