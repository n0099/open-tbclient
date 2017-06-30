package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.MemoryItemRemoveMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        String userIds;
        String[] split;
        String id;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103112 && (socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
            if (responseRemoveMembersMessage.getError() == 0 && responseRemoveMembersMessage.getOrginalMessage() != null && (responseRemoveMembersMessage.getOrginalMessage() instanceof RequestRemoveMembersMessage) && (userIds = ((RequestRemoveMembersMessage) responseRemoveMembersMessage.getOrginalMessage()).getUserIds()) != null && userIds.length() != 0 && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0 && (id = TbadkCoreApplication.getCurrentAccountObj().getID()) != null && id.length() != 0) {
                for (String str : split) {
                    if (id.equals(str)) {
                        MemoryItemRemoveMessage.a aVar = new MemoryItemRemoveMessage.a();
                        aVar.customGroupType = 1;
                        aVar.id = responseRemoveMembersMessage.getGroupId();
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(aVar));
                        return;
                    }
                }
            }
        }
    }
}
