package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ae;
/* loaded from: classes.dex */
public class c {
    private ae cBQ;
    private String forumId;
    private String threadId;

    public c(String str, String str2, ae aeVar) {
        this.forumId = str;
        this.threadId = str2;
        this.cBQ = aeVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ae alP() {
        return this.cBQ;
    }
}
