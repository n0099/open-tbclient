package com.baidu.tieba.account;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ AccountActivity aIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AccountActivity accountActivity, int i) {
        super(i);
        this.aIQ = accountActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || this.aIQ.aII == null) {
            return;
        }
        this.aIQ.Ih();
        if (this.aIQ.aIJ != null) {
            this.aIQ.aIJ.setData(this.aIQ.aII);
            this.aIQ.aIJ.notifyDataSetChanged();
        }
    }
}
