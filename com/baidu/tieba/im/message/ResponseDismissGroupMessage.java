package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.DelGroup.DelGroupRes;
/* loaded from: classes.dex */
public class ResponseDismissGroupMessage extends SocketResponsedMessage {
    private long a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        DelGroupRes.DelGroupResIdl parseFrom = DelGroupRes.DelGroupResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getGroupId();
        }
    }

    public final long d() {
        return this.a;
    }

    public ResponseDismissGroupMessage() {
        super(103104);
    }
}
