package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryItemRemoveMessage;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(103104, new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDismissGroupMessage) && socketResponsedMessage.getError() == 0) {
                    String valueOf = String.valueOf(((ResponseDismissGroupMessage) socketResponsedMessage).getGroupId());
                    MemoryItemRemoveMessage.a aVar = new MemoryItemRemoveMessage.a();
                    aVar.customGroupType = 1;
                    aVar.id = valueOf;
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(aVar));
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(103101) { // from class: com.baidu.tieba.im.Static.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddGroupMessage) && socketResponsedMessage.getError() == 0) {
                    ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
                    RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGroup_name(requestAddGroupMessage.getName());
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.a.a.ui(requestAddGroupMessage.getGroupType()));
                    AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
                    if (addGroupInfo != null) {
                        imMessageCenterPojo.setGroup_head(addGroupInfo.getPortrait());
                        imMessageCenterPojo.setGid(String.valueOf(addGroupInfo.getGroupId()));
                        imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.d.dm(1L));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016016, imMessageCenterPojo));
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(103112, new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.Static.3
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
        });
    }
}
