package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba extends com.baidu.adp.framework.c.g {
    final /* synthetic */ CommonGroupChatActiviy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(0);
        this.a = commonGroupChatActiviy;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        GroupData b;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            switch (socketResponsedMessage2.g()) {
                case 103101:
                case 103110:
                case 103112:
                    this.a.d.g();
                    return;
                case 103104:
                    if (socketResponsedMessage2 instanceof ResponseDismissGroupMessage) {
                        ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage2;
                        if (responseDismissGroupMessage.e() == 0 && (this.a.e instanceof CommonGroupMsglistModel) && (b = ((CommonGroupMsglistModel) this.a.e).b()) != null && b.getGroupId() == responseDismissGroupMessage.d()) {
                            this.a.finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
