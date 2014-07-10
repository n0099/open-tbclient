package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                if (responseDismissGroupMessage.getError() != 0) {
                    return;
                }
                this.a.a(responseDismissGroupMessage.getGroupId());
            } else if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                    this.a.j();
                }
            }
        }
    }
}
