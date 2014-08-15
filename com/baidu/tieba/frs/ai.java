package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ai extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            if (com.baidu.adp.lib.e.b.a(customResponsedMessage.getData().toString(), FrsActivity.d) == FrsActivity.d) {
                FrsActivity.m = false;
                FrsActivity.l = false;
                return;
            }
            FrsActivity.n = false;
            FrsActivity.l = false;
        }
    }
}
