package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsActivity frsActivity, int i) {
        super(i);
        this.aLX = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.w)) {
            com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) customResponsedMessage.getData();
            this.aLX.aJQ = wVar.getId();
            str = this.aLX.aJQ;
            if (TextUtils.isEmpty(str) || wVar.getPraise() == null) {
                return;
            }
            this.aLX.eS(wVar.getPraise().getIsLike());
        }
    }
}
