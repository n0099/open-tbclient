package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(FrsActivity frsActivity, int i) {
        super(i);
        this.bEL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
            com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) customResponsedMessage.getData();
            this.bEL.bDu = beVar.getId();
            str = this.bEL.bDu;
            if (TextUtils.isEmpty(str) || beVar.qp() == null) {
                return;
            }
            this.bEL.hl(beVar.qp().getIsLike());
        }
    }
}
