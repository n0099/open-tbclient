package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.framework.c.g {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(0);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            if (socketResponsedMessage2 instanceof ResponseDismissGroupMessage) {
                ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage2;
                if (responseDismissGroupMessage.e() == 0) {
                    b.a(this.a, responseDismissGroupMessage.d());
                }
            } else if (socketResponsedMessage2 instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage2;
                if (responseUpgradeMemberGroupMessage.e() == 0 || responseUpgradeMemberGroupMessage.e() == 2230110) {
                    this.a.e();
                }
            }
        }
    }
}
