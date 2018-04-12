package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import protobuf.QueryGroupDetail.DataReq;
import protobuf.QueryGroupDetail.QueryGroupDetailReqIdl;
/* loaded from: classes3.dex */
public class RequestGroupInfoLocalMessage extends CustomMessage<Object> {
    private int bigHeight;
    private int bigWidth;
    private String from;
    private long groupId;
    private int smallHeight;
    private int smallWidth;

    public RequestGroupInfoLocalMessage() {
        super(2001102);
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

    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.bigHeight = Integer.valueOf(getBigHeight());
        builder.bigWidth = Integer.valueOf(getBigWidth());
        builder.smallHeight = Integer.valueOf(getSmallHeight());
        builder.smallWidth = Integer.valueOf(getSmallWidth());
        builder.from = getFrom();
        builder.groupId = Long.valueOf(getGroupId());
        QueryGroupDetailReqIdl.Builder builder2 = new QueryGroupDetailReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
