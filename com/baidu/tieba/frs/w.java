package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(FrsActivity frsActivity, int i) {
        super(i);
        this.bgz = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
            com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
            this.bgz.beh = ahVar.getId();
            str = this.bgz.beh;
            if (TextUtils.isEmpty(str) || ahVar.getPraise() == null) {
                return;
            }
            this.bgz.gl(ahVar.getPraise().getIsLike());
        }
    }
}
