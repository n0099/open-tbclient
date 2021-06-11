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
/* loaded from: classes4.dex */
public class Static {

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDismissGroupMessage) && socketResponsedMessage.getError() == 0) {
                String valueOf = String.valueOf(((ResponseDismissGroupMessage) socketResponsedMessage).getGroupId());
                MemoryItemRemoveMessage.a aVar = new MemoryItemRemoveMessage.a();
                aVar.f17360a = 1;
                aVar.f17361b = valueOf;
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(aVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.a.c.c.g.c {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddGroupMessage) && socketResponsedMessage.getError() == 0) {
                ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
                RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGroup_name(requestAddGroupMessage.getName());
                imMessageCenterPojo.setCustomGroupType(d.a.n0.f1.m.a.a(requestAddGroupMessage.getGroupType()));
                AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
                if (addGroupInfo == null) {
                    return;
                }
                imMessageCenterPojo.setGroup_head(addGroupInfo.getPortrait());
                imMessageCenterPojo.setGid(String.valueOf(addGroupInfo.getGroupId()));
                imMessageCenterPojo.setPulled_msgId(d.a.n0.f1.w.b.a(1L));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016016, imMessageCenterPojo));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.a.c.c.g.c {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String userIds;
            String[] split;
            String id;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103112 && (socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
                ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
                if (responseRemoveMembersMessage.getError() != 0 || responseRemoveMembersMessage.getOrginalMessage() == null || !(responseRemoveMembersMessage.getOrginalMessage() instanceof RequestRemoveMembersMessage) || (userIds = ((RequestRemoveMembersMessage) responseRemoveMembersMessage.getOrginalMessage()).getUserIds()) == null || userIds.length() == 0 || (split = userIds.split(",")) == null || split.length == 0 || (id = TbadkCoreApplication.getCurrentAccountObj().getID()) == null || id.length() == 0) {
                    return;
                }
                for (String str : split) {
                    if (id.equals(str)) {
                        MemoryItemRemoveMessage.a aVar = new MemoryItemRemoveMessage.a();
                        aVar.f17360a = 1;
                        aVar.f17361b = responseRemoveMembersMessage.getGroupId();
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryItemRemoveMessage(aVar));
                        return;
                    }
                }
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(103104, new a(0));
        MessageManager.getInstance().registerListener(new b(103101));
        MessageManager.getInstance().registerListener(103112, new c(0));
    }
}
