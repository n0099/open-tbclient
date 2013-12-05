package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestHotGroupsMessage extends Message {
    private static final long serialVersionUID = -2294732609570625139L;
    private int height;
    private int offset;
    private int rn;
    private int width;

    public RequestHotGroupsMessage(int i, int i2, int i3, int i4) {
        super.setCmd(103012);
        this.width = i;
        this.height = i2;
        this.rn = i3;
        this.offset = i4;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public int getmWidth() {
        return this.width;
    }

    public void setmWidth(int i) {
        this.width = i;
    }

    public int getmHeight() {
        return this.height;
    }

    public void setmHeight(int i) {
        this.height = i;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public boolean isFirstPage() {
        return this.offset == 0;
    }
}
