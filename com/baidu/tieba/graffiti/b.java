package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ae;
/* loaded from: classes.dex */
public class b {
    private ae ctg;
    private String forumId;
    private String threadId;

    public b(String str, String str2, ae aeVar) {
        this.forumId = str;
        this.threadId = str2;
        this.ctg = aeVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ae agB() {
        return this.ctg;
    }
}
