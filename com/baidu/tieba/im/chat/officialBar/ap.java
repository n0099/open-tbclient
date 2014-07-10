package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(OfficialBarInfoActivity officialBarInfoActivity) {
        super(2001155);
        this.a = officialBarInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001155) {
            this.a.showToast(com.baidu.tieba.y.cash_del_suc);
        }
    }
}
