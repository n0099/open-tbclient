package com.baidu.tieba.im.message;

import protobuf.CommitGroupMsg.CommitGroupMsgRes;
/* loaded from: classes.dex */
public class ResponseCommitGroupMessage extends ResponseCommitMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        CommitGroupMsgRes.CommitGroupMsgResIdl parseFrom = CommitGroupMsgRes.CommitGroupMsgResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            b(parseFrom.getData().getMsgId() * 100);
            c(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
        }
    }

    public ResponseCommitGroupMessage() {
        super(202001);
    }
}
