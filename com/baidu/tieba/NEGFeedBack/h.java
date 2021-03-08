package com.baidu.tieba.NEGFeedBack;
/* loaded from: classes.dex */
public class h {
    private String forumId;
    private String forumName;
    private int gfZ;
    private int gga;
    private int ggb;
    private String ggc;
    private int userLevel;

    public h(int i, int i2, int i3) {
        this.gfZ = i;
        this.gga = i2;
        this.ggb = i3;
    }

    public int bKC() {
        return this.ggb;
    }

    public int bKD() {
        return this.gga;
    }

    public int bKE() {
        return this.gfZ;
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

    public String bKF() {
        return this.ggc;
    }

    public void setForumHeadUrl(String str) {
        this.ggc = str;
    }

    public int bKG() {
        return this.userLevel;
    }

    public void setUserLevel(int i) {
        this.userLevel = i;
    }
}
