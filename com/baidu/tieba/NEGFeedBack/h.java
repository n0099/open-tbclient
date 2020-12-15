package com.baidu.tieba.NEGFeedBack;
/* loaded from: classes21.dex */
public class h {
    private int fXe;
    private int fXf;
    private int fXg;
    private String fXh;
    private String forumId;
    private String forumName;
    private int userLevel;

    public h(int i, int i2, int i3) {
        this.fXe = i;
        this.fXf = i2;
        this.fXg = i3;
    }

    public int bLy() {
        return this.fXg;
    }

    public int bLz() {
        return this.fXf;
    }

    public int bLA() {
        return this.fXe;
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

    public String bLB() {
        return this.fXh;
    }

    public void setForumHeadUrl(String str) {
        this.fXh = str;
    }

    public int bLC() {
        return this.userLevel;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }
}
