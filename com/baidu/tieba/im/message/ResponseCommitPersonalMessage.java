package com.baidu.tieba.im.message;

import com.baidu.adp.lib.stats.a;
import com.squareup.wire.Wire;
import protobuf.CommitPersonalMsg.CommitPersonalMsgResIdl;
/* loaded from: classes.dex */
public class ResponseCommitPersonalMessage extends ResponseCommitMessage {
    public static final int CANT_CHAT = 2230303;
    private String toUserId;
    private int toUserType;

    public ResponseCommitPersonalMessage() {
        super(205001);
        this.toUserId = null;
        this.toUserType = 0;
    }

    public String getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(String str) {
        this.toUserId = str;
    }

    public int getToUserType() {
        return this.toUserType;
    }

    public void setToUserType(int i) {
        this.toUserType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        CommitPersonalMsgResIdl commitPersonalMsgResIdl = (CommitPersonalMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitPersonalMsgResIdl.class);
        setError(commitPersonalMsgResIdl.error.errorno.intValue());
        setErrorString(commitPersonalMsgResIdl.error.usermsg);
        if (getError() == 0) {
            if (commitPersonalMsgResIdl.data == null) {
                a.hl().b("im", 0L, (String) null, "comment", "personalchat_resdatanull");
            }
            long longValue = commitPersonalMsgResIdl.data.msgId.longValue();
            setToUserType(commitPersonalMsgResIdl.data.toUserType.intValue());
            setMsgId(com.baidu.tieba.im.util.g.aX(longValue));
            setRecordId(commitPersonalMsgResIdl.data.recordId.longValue());
            setGroupId(String.valueOf(commitPersonalMsgResIdl.data.groupId));
            setToUserId(String.valueOf(commitPersonalMsgResIdl.data.toUid));
        }
    }
}
