package com.baidu.tieba.im.a;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import java.util.List;
/* loaded from: classes.dex */
public class d extends j {
    public d() {
        super(202003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        MessageSyncMessage messageSyncMessage = null;
        if (socketResponsedMessage instanceof ResponsePullMessage) {
            if (socketResponsedMessage.getOrginalMessage() != null && (socketResponsedMessage.getOrginalMessage() instanceof MessageSyncMessage)) {
                messageSyncMessage = (MessageSyncMessage) socketResponsedMessage.getOrginalMessage();
            }
            if (messageSyncMessage != null) {
                com.baidu.tbadk.core.d.a.a("im", messageSyncMessage.getClientLogID(), messageSyncMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
            }
            if (socketResponsedMessage.getError() == 110000) {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
            }
            ResponsePullMessage responsePullMessage = (ResponsePullMessage) socketResponsedMessage;
            List<GroupMsgData> groupMsg = responsePullMessage.getGroupMsg();
            if (groupMsg != null && groupMsg.size() > 0) {
                for (GroupMsgData groupMsgData : groupMsg) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                        d(groupMsgData);
                    }
                }
            }
            if (!a(responsePullMessage)) {
                b.aRy().aRF();
                return socketResponsedMessage;
            }
            return socketResponsedMessage;
        }
        return null;
    }

    private void d(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(groupMsgData);
        }
    }

    private boolean a(ResponsePullMessage responsePullMessage) {
        Long l;
        if (responsePullMessage == null || responsePullMessage.getGroupMsg() == null || responsePullMessage.getGroupMsg().size() == 0 || responsePullMessage.hasError()) {
            return false;
        }
        List<GroupMsgData> groupMsg = responsePullMessage.getGroupMsg();
        if (responsePullMessage.getOrginalMessage() instanceof MessageSyncMessage) {
            MessageSyncMessage messageSyncMessage = (MessageSyncMessage) responsePullMessage.getOrginalMessage();
            if (messageSyncMessage.getGroupMids() == null || messageSyncMessage.getGroupMids().size() == 0) {
                return false;
            }
            LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
            LongSparseArray<Long> aRg = com.baidu.tieba.im.memorycache.b.aQV().aRg();
            boolean z = false;
            for (GroupMsgData groupMsgData : groupMsg) {
                if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                    if (com.baidu.tieba.im.memorycache.c.pM(groupMsgData.getGroupInfo().getCustomType())) {
                        Long l2 = aRg.get(groupMsgData.getGroupInfo().getGroupId());
                        if (l2 != null && (l = messageSyncMessage.getGroupMids().get(groupMsgData.getGroupInfo().getGroupId())) != null) {
                            if (l2.longValue() > l.longValue()) {
                                z = true;
                            }
                            if (groupMsgData.hasMore()) {
                                longSparseArray.put(groupMsgData.getGroupInfo().getGroupId(), l2);
                            }
                        }
                    }
                    z = z;
                }
            }
            if (!z || longSparseArray.size() <= 0) {
                return false;
            }
            b.aRy().a(longSparseArray);
            return true;
        }
        return false;
    }
}
