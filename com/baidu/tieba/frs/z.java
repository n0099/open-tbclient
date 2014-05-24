package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2003124) {
                if (customResponsedMessage.getCmd() != 2003122) {
                    return;
                }
                this.a.b(customResponsedMessage);
                return;
            }
            this.a.a(customResponsedMessage);
        }
    }
}
