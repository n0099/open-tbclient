package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(FrsActivity frsActivity, int i) {
        super(i);
        this.aUz = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.v)) {
            com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) customResponsedMessage.getData();
            this.aUz.aSp = vVar.getId();
            str = this.aUz.aSp;
            if (TextUtils.isEmpty(str) || vVar.getPraise() == null) {
                return;
            }
            this.aUz.fp(vVar.getPraise().getIsLike());
        }
    }
}
