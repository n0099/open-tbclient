package com.baidu.tbadk.live.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupsByFid.DataReq;
import protobuf.QueryLiveGroupsByFid.QueryLiveGroupsByFidReqIdl;
/* loaded from: classes.dex */
public class RequestFrsLiveListMessage extends TbSocketMessage {
    private int forumId;
    private int offset;
    private int rn;
    private int type;

    public RequestFrsLiveListMessage() {
        super(107001);
    }

    public int getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(getForumId());
        builder.type = Integer.valueOf(getType());
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        QueryLiveGroupsByFidReqIdl.Builder builder2 = new QueryLiveGroupsByFidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
