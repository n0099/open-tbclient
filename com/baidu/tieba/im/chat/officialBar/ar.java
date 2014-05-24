package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.model.bj;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(OfficialBarTipActivity officialBarTipActivity, int i) {
        super(i);
        this.a = officialBarTipActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bj bjVar;
        com.baidu.tieba.im.a<Void> aVar;
        bjVar = this.a.a;
        aVar = this.a.d;
        bjVar.a(aVar);
    }
}
