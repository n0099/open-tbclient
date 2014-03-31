package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.DelGroupMsgs.DelGroupMsgsRes;
/* loaded from: classes.dex */
public class ResponseDelSystemMessage extends SocketResponsedMessage {
    private long a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        DelGroupMsgsRes.DelGroupMsgsResIdl parseFrom = DelGroupMsgsRes.DelGroupMsgsResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getGroupId();
        }
    }

    public ResponseDelSystemMessage() {
        super(202004);
    }
}
