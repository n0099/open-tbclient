package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.MemoryItemRemoveMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
class k extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
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
            if (responseRemoveMembersMessage.getError() == 0 && responseRemoveMembersMessage.getOrginalMessage() != null && (responseRemoveMembersMessage.getOrginalMessage() instanceof RequestRemoveMembersMessage) && (userIds = ((RequestRemoveMembersMessage) responseRemoveMembersMessage.getOrginalMessage()).getUserIds()) != null && userIds.length() != 0 && (split = userIds.split(",")) != null && split.length != 0 && (id = TbadkCoreApplication.getCurrentAccountObj().getID()) != null && id.length() != 0) {
                for (String str : split) {
                    if (id.equals(str)) {
                        com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
                        fVar.customGroupType = 1;
                        fVar.id = responseRemoveMembersMessage.getGroupId();
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(fVar));
                        return;
                    }
                }
            }
        }
    }
}
