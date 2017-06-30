package com.baidu.tieba.account;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ AccountActivity aUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AccountActivity accountActivity, int i) {
        super(i);
        this.aUP = accountActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || this.aUP.aUG == null) {
            return;
        }
        this.aUP.KC();
        if (this.aUP.aUH != null) {
            this.aUP.aUH.setData(this.aUP.aUG);
            this.aUP.aUH.notifyDataSetChanged();
        }
    }
}
