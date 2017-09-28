package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a cYo;
    public BdUniqueId aPx;
    public int cYm = -1;
    public boolean cYn = false;
    private CustomMessageListener aoT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.cYn = true;
                }
            }
        }
    };

    public static synchronized a apr() {
        a aVar;
        synchronized (a.class) {
            if (cYo == null) {
                cYo = new a();
            }
            aVar = cYo;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aPx != null) {
            MessageManager.getInstance().unRegisterListener(this.aPx);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aPx = bdUniqueId;
            this.aoT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoT);
        }
    }
}
