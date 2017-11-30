package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* loaded from: classes.dex */
public class a {
    private static a dpu;
    public BdUniqueId aSv;
    public int dps = -1;
    public boolean dpt = false;
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc() && !updateAttentionMessage.isAttention() && updateAttentionMessage.isGod()) {
                    a.this.dpt = true;
                }
            }
        }
    };

    public static synchronized a atU() {
        a aVar;
        synchronized (a.class) {
            if (dpu == null) {
                dpu = new a();
            }
            aVar = dpu;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aSv != null) {
            MessageManager.getInstance().unRegisterListener(this.aSv);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aSv = bdUniqueId;
            this.mAttentionListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.mAttentionListener);
        }
    }
}
