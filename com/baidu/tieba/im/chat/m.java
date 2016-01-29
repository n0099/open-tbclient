package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
/* loaded from: classes.dex */
class m extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ CommonGroupChatActiviy bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(i);
        this.bNU = commonGroupChatActiviy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        GroupData group;
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case 103101:
                case 103110:
                case 103112:
                    this.bNU.bPJ.refresh();
                    return;
                case 103104:
                    if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                        ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                        if (responseDismissGroupMessage.getError() == 0 && (this.bNU.bPK instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.bNU.bPK).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                            this.bNU.finish();
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
