package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.ApplyJoinGroup.ApplyJoinGroupRes;
/* loaded from: classes.dex */
public class ResponseJoinGroupMessage extends SocketResponsedMessage {
    private int a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        ApplyJoinGroupRes.ApplyJoinGroupResIdl parseFrom = ApplyJoinGroupRes.ApplyJoinGroupResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getGroupId();
        }
    }

    public ResponseJoinGroupMessage() {
        super(103110);
    }
}
