package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestQueryGroupLocMessage extends Message {
    private static final long serialVersionUID = -8859973218001336337L;
    private int groupId;
    private String lat;
    private String lng;

    public RequestQueryGroupLocMessage() {
        setCmd(103010);
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
}
