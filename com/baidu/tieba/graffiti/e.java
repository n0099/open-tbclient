package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ae;
/* loaded from: classes.dex */
public class e {
    private String forumId;
    private ae mGraffitiInfo;
    private String threadId;

    public e(String str, String str2, ae aeVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = aeVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ae getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
