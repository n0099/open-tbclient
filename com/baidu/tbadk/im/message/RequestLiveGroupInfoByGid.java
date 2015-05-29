package com.baidu.tbadk.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryLiveGroupByGid.DataReq;
import protobuf.QueryLiveGroupByGid.QueryLiveGroupByGidReqIdl;
/* loaded from: classes.dex */
public class RequestLiveGroupInfoByGid extends TbSocketMessage {
    private int bigImageHeight;
    private int bigImageWidth;
    private int groupId;
    private int smallImageHeight;
    private int smallImageWidth;

    public RequestLiveGroupInfoByGid() {
        super(107008);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public void setBigHeight(int i) {
        this.bigImageHeight = i;
    }

    public void setBigWidth(int i) {
        this.bigImageWidth = i;
    }

    public void setSmallHeight(int i) {
        this.smallImageHeight = i;
    }

    public void setSmallWidth(int i) {
        this.smallImageWidth = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(this.groupId);
        builder.bigHeight = Integer.valueOf(this.bigImageHeight);
        builder.bigWidth = Integer.valueOf(this.bigImageWidth);
        builder.smallHeight = Integer.valueOf(this.smallImageHeight);
        builder.smallWidth = Integer.valueOf(this.smallImageWidth);
        QueryLiveGroupByGidReqIdl.Builder builder2 = new QueryLiveGroupByGidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
