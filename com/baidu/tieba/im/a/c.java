package com.baidu.tieba.im.a;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class c extends k {
    public c() {
        super(CmdConfigSocket.CMD_MESSAGE_SYNC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.f
    /* renamed from: d */
    public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        StringBuilder sb = new StringBuilder(200);
        if (socketMessage instanceof MessageSyncMessage) {
            LongSparseArray<Long> groupMids = ((MessageSyncMessage) socketMessage).getGroupMids();
            for (int i = 0; i < groupMids.size(); i++) {
                sb.append(groupMids.keyAt(i));
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(groupMids.valueAt(i));
                sb.append("|");
            }
            com.baidu.tbadk.core.d.a.a("im", socketMessage.getClientLogID(), CmdConfigSocket.CMD_MESSAGE_SYNC, "sendMsg", 0, null, TiebaInitialize.LogFields.REASON, "pull" + ((MessageSyncMessage) socketMessage).getSyncTypeString(), "comment", sb.toString());
        }
        return socketMessage;
    }
}
