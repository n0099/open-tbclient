package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a dbP;
    public BdUniqueId aOu;
    public int dbN = -1;
    public boolean dbO = false;
    private CustomMessageListener apK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.dbO = true;
                }
            }
        }
    };

    public static synchronized a aqM() {
        a aVar;
        synchronized (a.class) {
            if (dbP == null) {
                dbP = new a();
            }
            aVar = dbP;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aOu != null) {
            MessageManager.getInstance().unRegisterListener(this.aOu);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aOu = bdUniqueId;
            this.apK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.apK);
        }
    }
}
