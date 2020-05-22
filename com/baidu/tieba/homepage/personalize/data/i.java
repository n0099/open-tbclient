package com.baidu.tieba.homepage.personalize.data;
/* loaded from: classes9.dex */
public class i {
    private long ifb;
    private long liveId;
    private int liveType;
    private String portrait;
    private long threadId;
    private int type = 0;
    private String username;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public long getLiveId() {
        return this.liveId;
    }

    public void setLiveId(long j) {
        this.liveId = j;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public long cgu() {
        return this.ifb;
    }

    public void eo(long j) {
        this.ifb = j;
    }

    public int bBg() {
        return this.liveType;
    }

    public void wF(int i) {
        this.liveType = i;
    }
}
