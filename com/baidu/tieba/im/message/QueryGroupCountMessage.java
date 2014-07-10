package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupCount.DataReq;
import protobuf.QueryGroupCount.QueryGroupCountReqIdl;
/* loaded from: classes.dex */
public class QueryGroupCountMessage extends TbSocketMessage {
    private String lat;
    private String lng;

    public QueryGroupCountMessage() {
        super(103011);
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
        NumberFormatException e;
        double d;
        double d2 = 0.0d;
        try {
            d = Double.valueOf(this.lat).doubleValue();
        } catch (NumberFormatException e2) {
            e = e2;
            d = 0.0d;
        }
        try {
            d2 = Double.valueOf(this.lng).doubleValue();
        } catch (NumberFormatException e3) {
            e = e3;
            e.printStackTrace();
            DataReq.Builder builder = new DataReq.Builder();
            builder.lat = Double.valueOf(d);
            builder.lng = Double.valueOf(d2);
            QueryGroupCountReqIdl.Builder builder2 = new QueryGroupCountReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        DataReq.Builder builder3 = new DataReq.Builder();
        builder3.lat = Double.valueOf(d);
        builder3.lng = Double.valueOf(d2);
        QueryGroupCountReqIdl.Builder builder22 = new QueryGroupCountReqIdl.Builder();
        builder22.data = builder3.build(false);
        return builder22.build(false);
    }
}
