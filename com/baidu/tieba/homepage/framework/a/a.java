package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a cRa;
    public BdUniqueId aNy;
    public int cQY = -1;
    public boolean cQZ = false;
    private CustomMessageListener aoM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.cQZ = true;
                }
            }
        }
    };

    public static synchronized a aoe() {
        a aVar;
        synchronized (a.class) {
            if (cRa == null) {
                cRa = new a();
            }
            aVar = cRa;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aNy != null) {
            MessageManager.getInstance().unRegisterListener(this.aNy);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aNy = bdUniqueId;
            this.aoM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoM);
        }
    }
}
