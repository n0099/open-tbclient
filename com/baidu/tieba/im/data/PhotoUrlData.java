package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PhotoUrlData implements Serializable {
    private static final long serialVersionUID = -6994746964706195260L;
    private String bigurl;
    private String picId;
    private String smallurl;

    public String getPicId() {
        return this.picId;
    }

    public void setPicId(String str) {
        this.picId = str;
    }

    public String getSmallurl() {
        return this.smallurl;
    }

    public void setSmallurl(String str) {
        this.smallurl = str;
    }

    public String getBigurl() {
        return this.bigurl;
    }

    public void setBigurl(String str) {
        this.bigurl = str;
    }
}
