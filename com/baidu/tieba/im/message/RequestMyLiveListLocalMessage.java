package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import protobuf.QueryLiveGroupsByUid.DataReq;
import protobuf.QueryLiveGroupsByUid.QueryLiveGroupsByUidReqIdl;
/* loaded from: classes.dex */
public class RequestMyLiveListLocalMessage extends CustomMessage<Object> {
    private int offset;
    private int rn;
    private int type;

    public RequestMyLiveListLocalMessage() {
        super(MessageTypes.CMD_QUERY_MYLIVE_LOCAL);
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

    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        builder.type = Integer.valueOf(getType());
        QueryLiveGroupsByUidReqIdl.Builder builder2 = new QueryLiveGroupsByUidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
