package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(d dVar, int i) {
        super(i);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103104 && (socketResponsedMessage instanceof ResponseDismissGroupMessage)) {
            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
            if (responseDismissGroupMessage.getError() > 0) {
                this.a.b(responseDismissGroupMessage.getErrorString());
            } else if (responseDismissGroupMessage.getError() < 0) {
                this.a.a(y.neterror);
            } else {
                this.a.c(new StringBuilder(String.valueOf(responseDismissGroupMessage.getGroupId())).toString());
            }
        }
    }
}
