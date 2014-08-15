package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDismissGroupMessage) && socketResponsedMessage.getError() == 0) {
            this.a.a(String.valueOf(((ResponseDismissGroupMessage) socketResponsedMessage).getGroupId()));
        }
    }
}
