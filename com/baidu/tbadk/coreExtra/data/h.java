package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class h {
    private String afU;
    private EmotionGroupType afV;
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

    public EmotionGroupType wx() {
        return this.afV;
    }

    public void a(EmotionGroupType emotionGroupType) {
        this.afV = emotionGroupType;
    }

    public String wy() {
        return this.pname;
    }

    public void dY(String str) {
        this.pname = str;
    }

    public String getPid() {
        return this.afU;
    }

    public void dZ(String str) {
        this.afU = str;
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
