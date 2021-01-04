package com.baidu.tieba.NEGFeedBack;
/* loaded from: classes.dex */
public class h {
    private String forumId;
    private String forumName;
    private int ggK;
    private int ggL;
    private int ggM;
    private String ggN;
    private int userLevel;

    public h(int i, int i2, int i3) {
        this.ggK = i;
        this.ggL = i2;
        this.ggM = i3;
    }

    public int bNQ() {
        return this.ggM;
    }

    public int bNR() {
        return this.ggL;
    }

    public int bNS() {
        return this.ggK;
    }

    public void ej(String str, String str2) {
        this.forumId = str;
        this.forumName = str2;
    }

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String bNT() {
        return this.ggN;
    }

    public void setForumHeadUrl(String str) {
        this.ggN = str;
    }

    public int bNU() {
        return this.userLevel;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }
}
