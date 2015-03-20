package com.baidu.tieba.im.b;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.memorycache.bx;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import java.util.List;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.framework.a.j {
    private long bkY;

    public k() {
        super(202003);
        this.bkY = 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (!(socketResponsedMessage instanceof ResponsePullMessage)) {
            return null;
        }
        if (socketResponsedMessage.getError() == 110000) {
            MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
        }
        if (this.bkY % 10 == 0) {
            TiebaStatic.imNet(socketResponsedMessage);
            this.bkY++;
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
            b.SF().SM();
            return socketResponsedMessage;
        }
        return socketResponsedMessage;
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
            SparseArray<Long> Sn = com.baidu.tieba.im.memorycache.c.Sd().Sn();
            boolean z = false;
            for (GroupMsgData groupMsgData : groupMsg) {
                if (groupMsgData != null && groupMsgData.getGroupInfo() != null && bx.fY(groupMsgData.getGroupInfo().getCustomType()) && (l = Sn.get(groupMsgData.getGroupInfo().getGroupId())) != null && (l2 = messageSyncMessage.getGroupMids().get(groupMsgData.getGroupInfo().getGroupId())) != null) {
                    boolean z2 = l.longValue() > l2.longValue() ? true : z;
                    if (groupMsgData.hasMore()) {
                        sparseArray.put(groupMsgData.getGroupInfo().getGroupId(), l);
                    }
                    z = z2;
                }
            }
            if (!z || sparseArray.size() <= 0) {
                return false;
            }
            b.SF().d(sparseArray);
            return true;
        }
        return false;
    }
}
