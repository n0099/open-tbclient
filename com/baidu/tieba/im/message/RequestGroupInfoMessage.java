package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupDetail.DataReq;
import protobuf.QueryGroupDetail.QueryGroupDetailReqIdl;
/* loaded from: classes17.dex */
public class RequestGroupInfoMessage extends TbSocketMessage {
    private int bigHeight;
    private int bigWidth;
    private String from;
    private long groupId;
    private int smallHeight;
    private int smallWidth;

    public RequestGroupInfoMessage() {
        super(CmdConfigSocket.CMD_REQUEST_GROUP_INFO_BY_ID);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public int getSmallHeight() {
        return this.smallHeight;
    }

    public void setSmallHeight(int i) {
        this.smallHeight = i;
    }

    public int getSmallWidth() {
        return this.smallWidth;
    }

    public void setSmallWidth(int i) {
        this.smallWidth = i;
    }

    public int getBigHeight() {
        return this.bigHeight;
    }

    public void setBigHeight(int i) {
        this.bigHeight = i;
    }

    public int getBigWidth() {
        return this.bigWidth;
    }

    public void setBigWidth(int i) {
        this.bigWidth = i;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        long groupId = getGroupId();
        DataReq.Builder builder = new DataReq.Builder();
        builder.bigHeight = Integer.valueOf(getBigHeight());
        builder.bigWidth = Integer.valueOf(getBigWidth());
        builder.smallHeight = Integer.valueOf(getSmallHeight());
        builder.smallWidth = Integer.valueOf(getSmallWidth());
        builder.from = getFrom();
        builder.groupId = Long.valueOf(groupId);
        QueryGroupDetailReqIdl.Builder builder2 = new QueryGroupDetailReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
