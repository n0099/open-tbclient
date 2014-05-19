package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupsByUid.DataReq;
import protobuf.QueryLiveGroupsByUid.QueryLiveGroupsByUidReqIdl;
/* loaded from: classes.dex */
public class RequestMyLiveListMessage extends TbSocketMessage {
    private int offset;
    private int rn;
    private int type;

    public RequestMyLiveListMessage() {
        super(MessageTypes.CMD_QUERY_MYLIVE);
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
        builder.type = Integer.valueOf(getType());
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        QueryLiveGroupsByUidReqIdl.Builder builder2 = new QueryLiveGroupsByUidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
