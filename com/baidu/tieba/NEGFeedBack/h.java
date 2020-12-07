package com.baidu.tieba.NEGFeedBack;
/* loaded from: classes21.dex */
public class h {
    private int fXc;
    private int fXd;
    private int fXe;
    private String fXf;
    private String forumId;
    private String forumName;
    private int userLevel;

    public h(int i, int i2, int i3) {
        this.fXc = i;
        this.fXd = i2;
        this.fXe = i3;
    }

    public int bLx() {
        return this.fXe;
    }

    public int bLy() {
        return this.fXd;
    }

    public int bLz() {
        return this.fXc;
    }

    public void ek(String str, String str2) {
        this.forumId = str;
        this.forumName = str2;
    }

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String bLA() {
        return this.fXf;
    }

    public void setForumHeadUrl(String str) {
        this.fXf = str;
    }

    public int bLB() {
        return this.userLevel;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }
}
