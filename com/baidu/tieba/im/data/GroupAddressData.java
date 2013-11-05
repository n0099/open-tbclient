package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupAddressData implements Serializable {
    private static final long serialVersionUID = 5616188082014345808L;
    private String mLat;
    private String mLng;
    private String mPosition;

    public void setPosition(String str) {
        this.mPosition = str;
    }

    public void setLng(String str) {
        this.mLng = str;
    }

    public void setLat(String str) {
        this.mLat = str;
    }

    public String getPosition() {
        return this.mPosition;
    }

    public String getLng() {
        return this.mLng;
    }

    public String getLat() {
        return this.mLat;
    }
}
