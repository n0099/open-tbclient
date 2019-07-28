package com.baidu.tieba.im.a;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.xiaomi.mipush.sdk.Constants;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class c extends k {
    public c() {
        super(202003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
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
            com.baidu.tbadk.core.e.a.a(IXAdRequestInfo.IMSI, socketMessage.getClientLogID(), 202003, "sendMsg", 0, null, "reason", "pull" + ((MessageSyncMessage) socketMessage).getSyncTypeString(), ClientCookie.COMMENT_ATTR, sb.toString());
        }
        return socketMessage;
    }
}
