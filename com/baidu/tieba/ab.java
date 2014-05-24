package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case 2007009:
                    ai.c().M();
                    return;
                case 2007010:
                    ai.c().N();
                    return;
                case 2007011:
                    ai.c().P();
                    return;
                case 2007012:
                    ai.c().Q();
                    return;
                case 2007013:
                    ai.c().L();
                    return;
                case 2007014:
                default:
                    return;
                case 2007015:
                    ai.c().O();
                    return;
            }
        }
    }
}
