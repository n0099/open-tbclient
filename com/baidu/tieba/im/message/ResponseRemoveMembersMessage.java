package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.DelGroupUsers.DelGroupUsersRes;
/* loaded from: classes.dex */
public class ResponseRemoveMembersMessage extends SocketResponsedMessage {
    private String a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        DelGroupUsersRes.DelGroupUsersResIdl parseFrom = DelGroupUsersRes.DelGroupUsersResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = String.valueOf(parseFrom.getData().getGroupId());
        }
    }

    public final String d() {
        return this.a;
    }

    public ResponseRemoveMembersMessage() {
        super(103112);
    }
}
