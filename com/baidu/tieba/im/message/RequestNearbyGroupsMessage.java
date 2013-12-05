package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestNearbyGroupsMessage extends Message {
    private static final long serialVersionUID = 5970126981799423191L;
    private int geo;
    private int height;
    private String lat;
    private String lng;
    private int offset;
    private int rn;
    private int width;

    public RequestNearbyGroupsMessage() {
        setCmd(103009);
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
}
