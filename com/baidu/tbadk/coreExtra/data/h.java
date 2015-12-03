package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private String aic;
    private EmotionGroupType aid;
    private int height;
    private String name;
    private String pname;
    private int width;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public EmotionGroupType xh() {
        return this.aid;
    }

    public void a(EmotionGroupType emotionGroupType) {
        this.aid = emotionGroupType;
    }

    public String xi() {
        return this.pname;
    }

    public void dU(String str) {
        this.pname = str;
    }

    public String getPid() {
        return this.aic;
    }

    public void setPid(String str) {
        this.aic = str;
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
}
