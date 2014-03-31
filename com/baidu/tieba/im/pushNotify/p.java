package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends com.baidu.adp.framework.c.g {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i) {
        super(202006);
        this.a = oVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            com.baidu.adp.lib.util.f.e("cmd:" + socketResponsedMessage2.g());
            switch (socketResponsedMessage2.g()) {
                case 202006:
                    if (socketResponsedMessage2 instanceof PushNotifyMessage) {
                        o.a(this.a, (PushNotifyMessage) socketResponsedMessage2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
