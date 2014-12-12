package com.baidu.tieba.im.message.chat;

import com.baidu.adp.lib.g.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReqIdl;
import protobuf.CommitPersonalMsg.DataReq;
/* loaded from: classes.dex */
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
            if (c.a(TbadkCoreApplication.getCurrentAccount(), 0L) != getUserInfo().getUserIdLong()) {
                userType = getUserInfo().getUserType();
            } else {
                userType = getToUserInfo().getUserType();
            }
            builder.toUserType = Integer.valueOf(userType);
            CommitPersonalMsgReqIdl.Builder builder2 = new CommitPersonalMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
