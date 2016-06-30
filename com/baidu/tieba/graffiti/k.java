package com.baidu.tieba.graffiti;
/* loaded from: classes.dex */
public class k {
    private String forumId;
    private com.baidu.tbadk.core.data.w mGraffitiInfo;
    private String threadId;

    public k(String str, String str2, com.baidu.tbadk.core.data.w wVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = wVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public com.baidu.tbadk.core.data.w getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
