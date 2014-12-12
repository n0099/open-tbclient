package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class f {
    private String QH;
    private EmotionGroupType QI;
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

    public EmotionGroupType rz() {
        return this.QI;
    }

    public void a(EmotionGroupType emotionGroupType) {
        this.QI = emotionGroupType;
    }

    public String rA() {
        return this.pname;
    }

    public void dh(String str) {
        this.pname = str;
    }

    public String getPid() {
        return this.QH;
    }

    public void setPid(String str) {
        this.QH = str;
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
