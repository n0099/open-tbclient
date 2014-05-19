package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ CommonGroupChatActiviy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(i);
        this.a = commonGroupChatActiviy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        GroupData b;
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case MessageTypes.CMD_ADD_GROUP /* 103101 */:
                case MessageTypes.CMD_JOIN_GROUP /* 103110 */:
                case MessageTypes.CMD_REMOVE_MEMBERS /* 103112 */:
                    this.a.d.j();
                    return;
                case MessageTypes.CMD_DISSMISS_GROUP /* 103104 */:
                    if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                        ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                        if (responseDismissGroupMessage.getError() == 0 && (this.a.e instanceof CommonGroupMsglistModel) && (b = ((CommonGroupMsglistModel) this.a.e).b()) != null && b.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
