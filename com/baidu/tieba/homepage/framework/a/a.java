package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a dqz;
    public BdUniqueId aSy;
    public int dqx = -1;
    public boolean dqy = false;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.dqy = true;
                }
            }
        }
    };

    public static synchronized a auc() {
        a aVar;
        synchronized (a.class) {
            if (dqz == null) {
                dqz = new a();
            }
            aVar = dqz;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aSy != null) {
            MessageManager.getInstance().unRegisterListener(this.aSy);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aSy = bdUniqueId;
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }
}
