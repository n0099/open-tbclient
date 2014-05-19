package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryHotLiveGroups.DataReq;
import protobuf.QueryHotLiveGroups.QueryHotLiveGroupsReqIdl;
/* loaded from: classes.dex */
public class RequestHotLiveListMessage extends TbSocketMessage {
    private int height;
    private int offset;
    private int rn;
    private int type;
    private int width;

    public RequestHotLiveListMessage() {
        super(MessageTypes.CMD_REQUEST_LIVE_LIST_ALL);
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

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = Integer.valueOf(getType());
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        QueryHotLiveGroupsReqIdl.Builder builder2 = new QueryHotLiveGroupsReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
