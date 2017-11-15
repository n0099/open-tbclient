package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a dgO;
    public BdUniqueId aPy;
    public int dgM = -1;
    public boolean dgN = false;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.dgN = true;
                }
            }
        }
    };

    public static synchronized a asb() {
        a aVar;
        synchronized (a.class) {
            if (dgO == null) {
                dgO = new a();
            }
            aVar = dgO;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aPy != null) {
            MessageManager.getInstance().unRegisterListener(this.aPy);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aPy = bdUniqueId;
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }
}
