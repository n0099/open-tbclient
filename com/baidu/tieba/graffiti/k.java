package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.z;
/* loaded from: classes.dex */
public class k {
    private String forumId;
    private z mGraffitiInfo;
    private String threadId;

    public k(String str, String str2, z zVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = zVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public z getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
