package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ac;
/* loaded from: classes.dex */
public class k {
    private String forumId;
    private ac mGraffitiInfo;
    private String threadId;

    public k(String str, String str2, ac acVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = acVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ac getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
