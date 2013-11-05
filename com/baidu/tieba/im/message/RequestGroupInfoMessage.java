package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestGroupInfoMessage extends Message {
    private static final long serialVersionUID = 5450094930675684876L;
    private int bigHeight;
    private int bigWidth;
    private String from;
    private long groupId;
    private int smallHeight;
    private int smallWidth;

    public RequestGroupInfoMessage() {
        setCmd(103004);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public int getSmallHeight() {
        return this.smallHeight;
    }

    public void setSmallHeight(int i) {
        this.smallHeight = i;
    }

    public int getSmallWidth() {
        return this.smallWidth;
    }

    public void setSmallWidth(int i) {
        this.smallWidth = i;
    }

    public int getBigHeight() {
        return this.bigHeight;
    }

    public void setBigHeight(int i) {
        this.bigHeight = i;
    }

    public int getBigWidth() {
        return this.bigWidth;
    }

    public void setBigWidth(int i) {
        this.bigWidth = i;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }
}
