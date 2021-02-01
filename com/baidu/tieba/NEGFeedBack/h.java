package com.baidu.tieba.NEGFeedBack;
/* loaded from: classes.dex */
public class h {
    private String forumId;
    private String forumName;
    private int ger;
    private int ges;
    private int get;
    private String geu;
    private int userLevel;

    public h(int i, int i2, int i3) {
        this.ger = i;
        this.ges = i2;
        this.get = i3;
    }

    public int bKt() {
        return this.get;
    }

    public int bKu() {
        return this.ges;
    }

    public int bKv() {
        return this.ger;
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

    public String bKw() {
        return this.geu;
    }

    public void setForumHeadUrl(String str) {
        this.geu = str;
    }

    public int bKx() {
        return this.userLevel;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }
}
