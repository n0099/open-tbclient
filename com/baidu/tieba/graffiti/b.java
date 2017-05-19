package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ae;
/* loaded from: classes.dex */
public class b {
    private ae cmI;
    private String forumId;
    private String threadId;

    public b(String str, String str2, ae aeVar) {
        this.forumId = str;
        this.threadId = str2;
        this.cmI = aeVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ae afm() {
        return this.cmI;
    }
}
