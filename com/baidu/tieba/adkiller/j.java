package com.baidu.tieba.adkiller;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i, int i2) {
        super(i, i2);
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage.getError() == 0 && (responsedMessage.getOrginalMessage().getExtra() instanceof SubmitCloseNetMessage)) {
            SubmitCloseNetMessage submitCloseNetMessage = (SubmitCloseNetMessage) responsedMessage.getOrginalMessage().getExtra();
            String killTag = submitCloseNetMessage.getKillTag();
            int type = submitCloseNetMessage.getType();
            if (type == 2) {
                b.gT(killTag);
            } else if (type == 1) {
                b.gU(killTag);
            }
            a aVar = new a();
            aVar.tag = killTag;
            aVar.type = type;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_AD_KILLER_SUBMIT_SUCCESS, aVar));
        }
    }
}
