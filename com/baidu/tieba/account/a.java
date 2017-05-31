package com.baidu.tieba.account;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ AccountActivity aTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AccountActivity accountActivity, int i) {
        super(i);
        this.aTw = accountActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || this.aTw.aTn == null) {
            return;
        }
        this.aTw.Ke();
        if (this.aTw.aTo != null) {
            this.aTw.aTo.setData(this.aTw.aTn);
            this.aTw.aTo.notifyDataSetChanged();
        }
    }
}
