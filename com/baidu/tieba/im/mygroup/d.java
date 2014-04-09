package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
/* loaded from: classes.dex */
final class d extends com.baidu.adp.framework.c.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MyGroupFragment myGroupFragment, int i) {
        super(0);
        this.a = myGroupFragment;
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
                    this.a.c = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
