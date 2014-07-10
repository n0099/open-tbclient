package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.CommitInviteMsg.CommitInviteMsgReqIdl;
import protobuf.CommitInviteMsg.DataReq;
/* loaded from: classes.dex */
public class RequestCommitInviteMessage extends TbSocketMessage {
    private DataReq mReqData;

    public RequestCommitInviteMessage() {
        super(205002);
    }

    public void setReqData(DataReq dataReq) {
        this.mReqData = dataReq;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        if (this.mReqData != null) {
            CommitInviteMsgReqIdl.Builder builder = new CommitInviteMsgReqIdl.Builder();
            builder.data = this.mReqData;
            return builder.build(false);
        }
        return null;
    }
}
