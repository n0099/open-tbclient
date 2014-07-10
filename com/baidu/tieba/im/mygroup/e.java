package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MyGroupFragment myGroupFragment, int i) {
        super(i);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        switch (socketResponsedMessage.getCmd()) {
            case 103101:
            case 103102:
            case 103104:
            case 103105:
            case 103112:
            case 2001109:
                if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() == 0 || ((socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) && socketResponsedMessage.getError() == 2230110)) {
                    this.a.c = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
