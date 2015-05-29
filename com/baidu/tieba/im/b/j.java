package com.baidu.tieba.im.b;

import android.util.SparseArray;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.im.message.MessageSyncMessage;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.a.k {
    public j() {
        super(202003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        StringBuilder sb = new StringBuilder(200);
        if (socketMessage instanceof MessageSyncMessage) {
            SparseArray<Long> groupMids = ((MessageSyncMessage) socketMessage).getGroupMids();
            for (int i = 0; i < groupMids.size(); i++) {
                sb.append(groupMids.keyAt(i));
                sb.append("-");
                sb.append(groupMids.valueAt(i));
                sb.append("|");
            }
            com.baidu.tbadk.core.log.b.a("im", socketMessage.getClientLogID(), 202003, "sendMsg", 0, null, "reason", "pull" + ((MessageSyncMessage) socketMessage).getSyncTypeString(), "comment", sb.toString());
        }
        return socketMessage;
    }
}
