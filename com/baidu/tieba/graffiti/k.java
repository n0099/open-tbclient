package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.u;
/* loaded from: classes.dex */
public class k {
    private String forumId;
    private u mGraffitiInfo;
    private String threadId;

    public k(String str, String str2, u uVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = uVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public u getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
