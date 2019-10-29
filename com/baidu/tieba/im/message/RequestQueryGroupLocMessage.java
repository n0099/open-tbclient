package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupLocation.DataReq;
import protobuf.QueryGroupLocation.QueryGroupLocationReqIdl;
/* loaded from: classes5.dex */
public class RequestQueryGroupLocMessage extends TbSocketMessage {
    private long groupId;
    private String lat;
    private String lng;

    public RequestQueryGroupLocMessage() {
        super(CmdConfigSocket.CMD_QUERY_GROUPLOC);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
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
        builder.groupId = Long.valueOf(getGroupId());
        builder.lat = Double.valueOf(Double.parseDouble(getLat()));
        builder.lng = Double.valueOf(Double.parseDouble(getLng()));
        QueryGroupLocationReqIdl.Builder builder2 = new QueryGroupLocationReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
