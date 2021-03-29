package com.baidu.tieba.im.message.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.m.b;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReqIdl;
import protobuf.CommitPersonalMsg.DataReq;
/* loaded from: classes3.dex */
public class OfficialChatMessage extends ChatMessage {
    public OfficialChatMessage() {
        super(205001);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        int userType;
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.content = getContent();
            builder.toUid = Long.valueOf(getToUserId());
            builder.msgType = Integer.valueOf(getMsgType());
            builder.recordId = Long.valueOf(getRecordId());
            if (b.f(TbadkCoreApplication.getCurrentAccount(), 0L) != getUserInfo().getUserIdLong()) {
                userType = getUserInfo().getUserType();
            } else {
                userType = getToUserInfo().getUserType();
            }
            builder.toUserType = Integer.valueOf(userType);
            CommitPersonalMsgReqIdl.Builder builder2 = new CommitPersonalMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }
}
