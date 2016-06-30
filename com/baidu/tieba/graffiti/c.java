package com.baidu.tieba.graffiti;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tbadk.core.data.w ciD;
    private String forumId;
    private String threadId;

    public c(String str, String str2, com.baidu.tbadk.core.data.w wVar) {
        this.forumId = str;
        this.threadId = str2;
        this.ciD = wVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public com.baidu.tbadk.core.data.w aes() {
        return this.ciD;
    }
}
