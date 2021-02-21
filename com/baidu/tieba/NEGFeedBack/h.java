package com.baidu.tieba.NEGFeedBack;
/* loaded from: classes.dex */
public class h {
    private String forumId;
    private String forumName;
    private int gew;
    private int gex;
    private int gey;
    private String gez;
    private int userLevel;

    public h(int i, int i2, int i3) {
        this.gew = i;
        this.gex = i2;
        this.gey = i3;
    }

    public int bKy() {
        return this.gey;
    }

    public int bKz() {
        return this.gex;
    }

    public int bKA() {
        return this.gew;
    }

    public void eg(String str, String str2) {
        this.forumId = str;
        this.forumName = str2;
    }

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String bKB() {
        return this.gez;
    }

    public void setForumHeadUrl(String str) {
        this.gez = str;
    }

    public int bKC() {
        return this.userLevel;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }
}
