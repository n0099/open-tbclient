package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import protobuf.QueryHotLiveGroups.DataReq;
import protobuf.QueryHotLiveGroups.QueryHotLiveGroupsReqIdl;
/* loaded from: classes.dex */
public class RequestHotLiveListLocalMessage extends CustomMessage<Object> {
    private int height;
    private int offset;
    private int rn;
    private int type;
    private int width;

    public RequestHotLiveListLocalMessage() {
        super(2001214);
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

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        builder.type = Integer.valueOf(getType());
        QueryHotLiveGroupsReqIdl.Builder builder2 = new QueryHotLiveGroupsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
