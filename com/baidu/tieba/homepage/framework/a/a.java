package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a cYc;
    public BdUniqueId aPk;
    public int cYa = -1;
    public boolean cYb = false;
    private CustomMessageListener aoH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.cYb = true;
                }
            }
        }
    };

    public static synchronized a apm() {
        a aVar;
        synchronized (a.class) {
            if (cYc == null) {
                cYc = new a();
            }
            aVar = cYc;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aPk != null) {
            MessageManager.getInstance().unRegisterListener(this.aPk);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aPk = bdUniqueId;
            this.aoH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoH);
        }
    }
}
