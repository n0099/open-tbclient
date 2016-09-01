package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.aa;
/* loaded from: classes.dex */
public class k {
    private String forumId;
    private aa mGraffitiInfo;
    private String threadId;

    public k(String str, String str2, aa aaVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = aaVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public aa getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
