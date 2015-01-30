package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.live.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ CommonGroupChatActiviy aRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(i);
        this.aRn = commonGroupChatActiviy;
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
                    this.aRn.mListView.refresh();
                    return;
                case 103104:
                    if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                        ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                        if (responseDismissGroupMessage.getError() == 0 && (this.aRn.mListModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.aRn.mListModel).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                            this.aRn.finish();
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
