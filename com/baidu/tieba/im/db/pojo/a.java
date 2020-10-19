package com.baidu.tieba.im.db.pojo;
/* loaded from: classes.dex */
public class a {
    private long cDo;
    private String forumName;
    private String gid;
    private String jKc;
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

    public String cLL() {
        return this.jKc;
    }

    public void LV(String str) {
        this.jKc = str;
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

    public long cJw() {
        return this.cDo;
    }

    public void fH(long j) {
        this.cDo = j;
    }
}
