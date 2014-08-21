package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupsByLocation.DataReq;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationReqIdl;
/* loaded from: classes.dex */
public class RequestNearbyGroupsMessage extends TbSocketMessage {
    private int geo;
    private int height;
    private String lat;
    private String lng;
    private int offset;
    private int rn;
    private int width;

    public RequestNearbyGroupsMessage() {
        super(103009);
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

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getGeo() {
        return this.geo;
    }

    public void setGeo(int i) {
        this.geo = i;
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
        builder.lat = Double.valueOf(com.baidu.adp.lib.e.c.a(getLat(), 0.0d));
        builder.lng = Double.valueOf(com.baidu.adp.lib.e.c.a(getLng(), 0.0d));
        builder.geo = Integer.valueOf(getGeo());
        builder.offset = Integer.valueOf(getOffset());
        builder.rn = Integer.valueOf(getRn());
        builder.height = Integer.valueOf(getHeight());
        builder.width = Integer.valueOf(getHeight());
        QueryGroupsByLocationReqIdl.Builder builder2 = new QueryGroupsByLocationReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
