package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.aa;
/* loaded from: classes.dex */
public class c {
    private aa cwb;
    private String forumId;
    private String threadId;

    public c(String str, String str2, aa aaVar) {
        this.forumId = str;
        this.threadId = str2;
        this.cwb = aaVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public aa ajG() {
        return this.cwb;
    }
}
