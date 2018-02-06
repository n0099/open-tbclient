package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupLocation.DataReq;
import protobuf.QueryGroupLocation.QueryGroupLocationReqIdl;
/* loaded from: classes3.dex */
public class RequestQueryGroupLocMessage extends TbSocketMessage {
    private int groupId;
    private String lat;
    private String lng;

    public RequestQueryGroupLocMessage() {
        super(103010);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.groupId = Integer.valueOf(getGroupId());
        builder.lat = Double.valueOf(Double.parseDouble(getLat()));
        builder.lng = Double.valueOf(Double.parseDouble(getLng()));
        QueryGroupLocationReqIdl.Builder builder2 = new QueryGroupLocationReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
