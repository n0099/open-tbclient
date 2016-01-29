package com.baidu.tieba.im.b;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.memorycache.bz;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import java.util.List;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.a.j {
    public j() {
        super(202003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponsePullMessage) {
            MessageSyncMessage messageSyncMessage = (socketResponsedMessage.getOrginalMessage() == null || !(socketResponsedMessage.getOrginalMessage() instanceof MessageSyncMessage)) ? null : (MessageSyncMessage) socketResponsedMessage.getOrginalMessage();
            if (messageSyncMessage != null) {
                com.baidu.tbadk.core.log.b.a("im", messageSyncMessage.getClientLogID(), messageSyncMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
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
                b.aea().aeh();
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
        Long l2;
        if (responsePullMessage == null || responsePullMessage.getGroupMsg() == null || responsePullMessage.getGroupMsg().size() == 0 || responsePullMessage.hasError()) {
            return false;
        }
        List<GroupMsgData> groupMsg = responsePullMessage.getGroupMsg();
        if (responsePullMessage.getOrginalMessage() instanceof MessageSyncMessage) {
            MessageSyncMessage messageSyncMessage = (MessageSyncMessage) responsePullMessage.getOrginalMessage();
            if (messageSyncMessage.getGroupMids() == null || messageSyncMessage.getGroupMids().size() == 0) {
                return false;
            }
            SparseArray<Long> sparseArray = new SparseArray<>();
            SparseArray<Long> adI = com.baidu.tieba.im.memorycache.b.ady().adI();
            boolean z = false;
            for (GroupMsgData groupMsgData : groupMsg) {
                if (groupMsgData != null && groupMsgData.getGroupInfo() != null && bz.ji(groupMsgData.getGroupInfo().getCustomType()) && (l = adI.get((int) groupMsgData.getGroupInfo().getGroupId())) != null && (l2 = messageSyncMessage.getGroupMids().get((int) groupMsgData.getGroupInfo().getGroupId())) != null) {
                    boolean z2 = l.longValue() > l2.longValue() ? true : z;
                    if (groupMsgData.hasMore()) {
                        sparseArray.put((int) groupMsgData.getGroupInfo().getGroupId(), l);
                    }
                    z = z2;
                }
            }
            if (!z || sparseArray.size() <= 0) {
                return false;
            }
            b.aea().c(sparseArray);
            return true;
        }
        return false;
    }
}
