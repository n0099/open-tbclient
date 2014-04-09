package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.AddGroupUsers.AddGroupUsersRes;
/* loaded from: classes.dex */
public class ResponseAddGroupUserMessage extends SocketResponsedMessage {
    private int a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        AddGroupUsersRes.AddGroupUsersResIdl parseFrom = AddGroupUsersRes.AddGroupUsersResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getGroupId();
        }
    }

    public ResponseAddGroupUserMessage() {
        super(103111);
    }
}
