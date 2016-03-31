package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(FrsActivity frsActivity, int i) {
        super(i);
        this.blk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.as)) {
            com.baidu.tbadk.core.data.as asVar = (com.baidu.tbadk.core.data.as) customResponsedMessage.getData();
            this.blk.biU = asVar.getId();
            str = this.blk.biU;
            if (TextUtils.isEmpty(str) || asVar.getPraise() == null) {
                return;
            }
            this.blk.gB(asVar.getPraise().getIsLike());
        }
    }
}
