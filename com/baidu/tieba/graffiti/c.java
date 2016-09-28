package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ac;
/* loaded from: classes.dex */
public class c {
    private ac cwG;
    private String forumId;
    private String threadId;

    public c(String str, String str2, ac acVar) {
        this.forumId = str;
        this.threadId = str2;
        this.cwG = acVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ac ajU() {
        return this.cwG;
    }
}
