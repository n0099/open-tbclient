package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.bw;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.framework.a.j {
    private long a;

    public l() {
        super(202003);
        this.a = 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        GroupMsgData next;
        if (socketResponsedMessage instanceof ResponsePullMessage) {
            if (socketResponsedMessage.getError() == 110000) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnLoginMessage());
            }
            if (this.a % 10 == 0) {
                TiebaStatic.imNet(socketResponsedMessage);
                this.a++;
            }
            b.b().i();
            Iterator<GroupMsgData> it = ((ResponsePullMessage) socketResponsedMessage).getGroupMsg().iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                b(next);
                GroupIdTypeData groupInfo = next.getGroupInfo();
                switch (groupInfo.getGroupType()) {
                    case 1:
                        groupInfo.setCustomType(0);
                        c(next);
                        continue;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        groupInfo.setCustomType(1);
                        c(next);
                        continue;
                    case 6:
                        a(next);
                        continue;
                    case 7:
                        groupInfo.setCustomType(3);
                        c(next);
                        continue;
                    case 8:
                        groupInfo.setCustomType(5);
                        c(next);
                        break;
                    case 21:
                        groupInfo.setCustomType(7);
                        c(next);
                        continue;
                }
                groupInfo.setCustomType(6);
                c(next);
            }
        }
        return null;
    }

    private void a(GroupMsgData groupMsgData) {
        String currentAccount;
        long j;
        int i;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            w.a(groupMsgData.getGroupInfo().getGroupId());
            if (groupMsgData.getListMessage() != null && (currentAccount = TbadkApplication.getCurrentAccount()) != null) {
                long a = com.baidu.adp.lib.f.b.a(currentAccount, 0L);
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                HashMap hashMap = new HashMap();
                for (ChatMessage chatMessage : listMessage) {
                    long userId = chatMessage.getUserId();
                    int userType = chatMessage.getUserInfo().getUserType();
                    if (userId == a) {
                        j = chatMessage.getToUserId();
                        i = chatMessage.getToUserInfo().getUserType();
                    } else {
                        j = userId;
                        i = userType;
                    }
                    GroupMsgData groupMsgData2 = (GroupMsgData) hashMap.get(Long.valueOf(j));
                    if (groupMsgData2 == null) {
                        if (i == 1) {
                            groupMsgData2 = new GroupMsgData(2013003);
                            groupMsgData2.getGroupInfo().setCustomType(4);
                        } else {
                            groupMsgData2 = new GroupMsgData(2013001);
                            groupMsgData2.getGroupInfo().setCustomType(2);
                        }
                        hashMap.put(Long.valueOf(j), groupMsgData2);
                    }
                    groupMsgData2.getListMessage().add(chatMessage);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        c((GroupMsgData) entry.getValue());
                    }
                }
            }
        }
    }

    private void b(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            int groupId = groupMsgData.getGroupInfo().getGroupId();
            long j = 0;
            Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    ChatMessage next = it.next();
                    j = next.getMsgId() > j2 ? next.getMsgId() : j2;
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.e.a().a(groupId, bw.c(j2));
                    return;
                }
            }
        }
    }

    private void c(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(groupMsgData);
        }
    }
}
