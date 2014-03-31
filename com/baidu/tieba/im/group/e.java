package com.baidu.tieba.im.group;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends com.baidu.adp.framework.c.g {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, int i) {
        super(0);
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        switch (socketResponsedMessage2.g()) {
            case 103101:
            case 103102:
            case 103104:
            case 103105:
            case 103112:
            case 2001109:
                if (!(socketResponsedMessage2 instanceof com.baidu.adp.framework.message.f) || socketResponsedMessage2.e() == 0 || ((socketResponsedMessage2 instanceof ResponseUpgradeMemberGroupMessage) && socketResponsedMessage2.e() == 2230110)) {
                    this.a.a = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
