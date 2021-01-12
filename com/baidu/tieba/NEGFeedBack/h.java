package com.baidu.tieba.NEGFeedBack;
/* loaded from: classes.dex */
public class h {
    private String forumId;
    private String forumName;
    private int gcb;
    private int gcc;
    private int gcd;
    private String gce;
    private int userLevel;

    public h(int i, int i2, int i3) {
        this.gcb = i;
        this.gcc = i2;
        this.gcd = i3;
    }

    public int bJZ() {
        return this.gcd;
    }

    public int bKa() {
        return this.gcc;
    }

    public int bKb() {
        return this.gcb;
    }

    public void ei(String str, String str2) {
        this.forumId = str;
        this.forumName = str2;
    }

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String bKc() {
        return this.gce;
    }

    public void setForumHeadUrl(String str) {
        this.gce = str;
    }

    public int bKd() {
        return this.userLevel;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }
}
