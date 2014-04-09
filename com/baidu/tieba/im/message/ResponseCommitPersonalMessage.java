package com.baidu.tieba.im.message;

import protobuf.CommitPersonalMsg.CommitPersonalMsgRes;
/* loaded from: classes.dex */
public class ResponseCommitPersonalMessage extends ResponseCommitMessage {
    private String a;
    private int b;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        CommitPersonalMsgRes.CommitPersonalMsgResIdl parseFrom = CommitPersonalMsgRes.CommitPersonalMsgResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            long msgId = parseFrom.getData().getMsgId();
            this.b = parseFrom.getData().getToUserType();
            b(msgId * 100);
            c(parseFrom.getData().getRecordId());
            a(String.valueOf(parseFrom.getData().getGroupId()));
            this.a = String.valueOf(parseFrom.getData().getToUid());
        }
    }

    public ResponseCommitPersonalMessage() {
        super(205001);
        this.a = null;
        this.b = 0;
    }

    public final String k() {
        return this.a;
    }

    public final int l() {
        return this.b;
    }
}
