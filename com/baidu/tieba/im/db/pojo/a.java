package com.baidu.tieba.im.db.pojo;
/* loaded from: classes.dex */
public class a {
    private long cLK;
    private String forumName;
    private String gid;
    private String groupHead;
    private int unReadCount;
    private int userType;

    public String getGid() {
        return this.gid;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public int getUnReadCount() {
        return this.unReadCount;
    }

    public void setUnReadCount(int i) {
        this.unReadCount = i;
    }

    public String cOS() {
        return this.groupHead;
    }

    public void Mt(String str) {
        this.groupHead = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public long cMD() {
        return this.cLK;
    }

    public void fI(long j) {
        this.cLK = j;
    }
}
