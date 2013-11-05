package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestFrsGroupsMessage extends Message {
    private static final long serialVersionUID = 5970126981799423191L;
    private String forumId;
    private int height;
    private String offset;
    private String rn;
    private String type;
    private int width;

    public RequestFrsGroupsMessage() {
        setCmd(103002);
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

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getOffset() {
        return this.offset;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public String getRn() {
        return this.rn;
    }

    public void setRn(String str) {
        this.rn = str;
    }
}
