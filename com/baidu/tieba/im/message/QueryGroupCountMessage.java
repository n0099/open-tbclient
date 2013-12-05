package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class QueryGroupCountMessage extends Message {
    private String lat;
    private String lng;

    public QueryGroupCountMessage() {
        setCmd(103011);
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
}
