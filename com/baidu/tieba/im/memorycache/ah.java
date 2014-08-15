package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008016) {
            c.b().d();
        }
    }
}
