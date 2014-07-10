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
                case 2005009:
                    ai.c().J();
                    return;
                case 2005010:
                    ai.c().K();
                    return;
                case 2005011:
                    ai.c().M();
                    return;
                case 2005012:
                    ai.c().N();
                    return;
                case 2005013:
                    ai.c().I();
                    return;
                case 2005014:
                default:
                    return;
                case 2005015:
                    ai.c().L();
                    return;
            }
        }
    }
}
