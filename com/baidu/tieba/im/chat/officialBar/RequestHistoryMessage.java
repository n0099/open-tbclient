package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryHistoryMsg.DataReq;
import protobuf.QueryHistoryMsg.QueryHistoryMsgReqIdl;
/* loaded from: classes3.dex */
public class RequestHistoryMessage extends TbSocketMessage {
    private int forum_id;
    private int height;
    private int id;
    private int sHeight;
    private int sWidth;
    private long user_id;
    private int width;

    public RequestHistoryMessage(int i, long j, int i2) {
        super(208002);
        this.forum_id = 0;
        this.user_id = 0L;
        this.id = 0;
        this.width = 0;
        this.height = 0;
        this.sWidth = 0;
        this.sHeight = 0;
        this.forum_id = i;
        this.user_id = j;
        this.id = i2;
        LocalViewSize.ImageSize acA = LocalViewSize.acx().acA();
        this.width = acA.width;
        this.height = acA.height;
        LocalViewSize.ImageSize acz = LocalViewSize.acx().acz();
        this.sWidth = acz.width;
        this.sHeight = acz.height;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(this.forum_id);
        builder.userId = Long.valueOf(this.user_id);
        builder.id = Integer.valueOf(this.id);
        builder.width = Integer.valueOf(this.width);
        builder.height = Integer.valueOf(this.height);
        builder.smallWidth = Integer.valueOf(this.sWidth);
        builder.smallHeight = Integer.valueOf(this.sHeight);
        QueryHistoryMsgReqIdl.Builder builder2 = new QueryHistoryMsgReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getFid() {
        return this.forum_id;
    }

    public int getRequestId() {
        return this.id;
    }
}
