package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FrsActivity frsActivity, int i) {
        super(i);
        this.bgz = frsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2001124) {
                if (customResponsedMessage.getCmd() != 2001122) {
                    return;
                }
                this.bgz.f(customResponsedMessage);
                return;
            }
            this.bgz.e(customResponsedMessage);
        }
    }
}
