package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryForumDetail.DataReq;
import protobuf.QueryForumDetail.QueryForumDetailReqIdl;
/* loaded from: classes4.dex */
public class RequestOfficialBarInfoMessage extends TbSocketMessage {
    public int mForumId;
    public String mForumName;

    public RequestOfficialBarInfoMessage(int i2, String str) {
        super(208001);
        this.mForumId = 0;
        this.mForumName = null;
        this.mForumId = i2;
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(this.mForumId);
        builder.forumName = this.mForumName;
        QueryForumDetailReqIdl.Builder builder2 = new QueryForumDetailReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
