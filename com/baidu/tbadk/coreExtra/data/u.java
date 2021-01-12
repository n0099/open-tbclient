package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class u {
    private EmotionGroupType foJ;
    private int height;
    private String name;
    private String pid;
    private String pname;
    private String url;
    private int width;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public EmotionGroupType bwd() {
        return this.foJ;
    }

    public void a(EmotionGroupType emotionGroupType) {
        this.foJ = emotionGroupType;
    }

    public String bwe() {
        return this.pname;
    }

    public void BD(String str) {
        this.pname = str;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String str) {
        this.pid = str;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
