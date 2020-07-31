package com.baidu.tieba.im.chat.officialBar;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryForumDetail.DataReq;
import protobuf.QueryForumDetail.QueryForumDetailReqIdl;
/* loaded from: classes20.dex */
public class RequestOfficialBarInfoMessage extends TbSocketMessage {
    private int mForumId;
    private String mForumName;

    public RequestOfficialBarInfoMessage(int i, String str) {
        super(CmdConfigSocket.CMD_QUERY_OFFICIAL_BAR_INFO);
        this.mForumId = 0;
        this.mForumName = null;
        this.mForumId = i;
        this.mForumName = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(this.mForumId);
        builder.forumName = this.mForumName;
        QueryForumDetailReqIdl.Builder builder2 = new QueryForumDetailReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
