package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.u;
/* loaded from: classes.dex */
public class c {
    private u bKy;
    private String forumId;
    private String threadId;

    public c(String str, String str2, u uVar) {
        this.forumId = str;
        this.threadId = str2;
        this.bKy = uVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public u Ya() {
        return this.bKy;
    }
}
