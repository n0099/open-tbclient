package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class f {
    private String Ri;
    private EmotionGroupType Rj;
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

    public EmotionGroupType rM() {
        return this.Rj;
    }

    public void a(EmotionGroupType emotionGroupType) {
        this.Rj = emotionGroupType;
    }

    public String rN() {
        return this.pname;
    }

    public void dg(String str) {
        this.pname = str;
    }

    public String getPid() {
        return this.Ri;
    }

    public void setPid(String str) {
        this.Ri = str;
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
