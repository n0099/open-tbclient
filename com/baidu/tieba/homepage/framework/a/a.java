package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a daV;
    public BdUniqueId aOx;
    public int daT = -1;
    public boolean daU = false;
    private CustomMessageListener apM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.daU = true;
                }
            }
        }
    };

    public static synchronized a aqB() {
        a aVar;
        synchronized (a.class) {
            if (daV == null) {
                daV = new a();
            }
            aVar = daV;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aOx != null) {
            MessageManager.getInstance().unRegisterListener(this.aOx);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aOx = bdUniqueId;
            this.apM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.apM);
        }
    }
}
