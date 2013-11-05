package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class GroupsByUidMessage extends Message {
    private static final long serialVersionUID = -7947323403477224192L;
    private int height;
    private int width;

    public GroupsByUidMessage(int i, int i2) {
        setCmd(103003);
        this.width = i;
        this.height = i2;
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
