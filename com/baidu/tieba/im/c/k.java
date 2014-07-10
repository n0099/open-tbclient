package com.baidu.tieba.im.c;

import android.util.SparseArray;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.MessageSyncMessage;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.framework.a.k {
    public k() {
        super(202003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public SocketMessage a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        String str;
        StringBuilder sb = new StringBuilder((int) Constants.MEDIA_INFO);
        if (socketMessage instanceof MessageSyncMessage) {
            SparseArray<Long> groupMids = ((MessageSyncMessage) socketMessage).getGroupMids();
            for (int i = 0; i < groupMids.size(); i++) {
                sb.append(groupMids.keyAt(i));
                sb.append("-");
                sb.append(groupMids.valueAt(i));
                sb.append("|");
            }
            if (((MessageSyncMessage) socketMessage).isForTimer()) {
                str = "active";
            } else {
                str = "passive";
            }
            TiebaStatic.imLog(202003, ((MessageSyncMessage) socketMessage).getSquencedId(), str, "MessageSync-send-pullmsg", "succ", 0, "", 0L, 0, sb.toString());
        }
        return socketMessage;
    }
}
