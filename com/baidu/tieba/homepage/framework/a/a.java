package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a cSt;
    public BdUniqueId aOM;
    public int cSr = -1;
    public boolean cSs = false;
    private CustomMessageListener aqg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.cSs = true;
                }
            }
        }
    };

    public static synchronized a aoq() {
        a aVar;
        synchronized (a.class) {
            if (cSt == null) {
                cSt = new a();
            }
            aVar = cSt;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aOM != null) {
            MessageManager.getInstance().unRegisterListener(this.aOM);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aOM = bdUniqueId;
            this.aqg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aqg);
        }
    }
}
