package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class l {
    private String aps;
    private EmotionGroupType apt;
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

    public EmotionGroupType xM() {
        return this.apt;
    }

    public void a(EmotionGroupType emotionGroupType) {
        this.apt = emotionGroupType;
    }

    public String xN() {
        return this.pname;
    }

    public void ed(String str) {
        this.pname = str;
    }

    public String getPid() {
        return this.aps;
    }

    public void ee(String str) {
        this.aps = str;
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
