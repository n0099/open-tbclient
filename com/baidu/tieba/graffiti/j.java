package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.af;
/* loaded from: classes.dex */
public class j {
    private String forumId;
    private af mGraffitiInfo;
    private String threadId;

    public j(String str, String str2, af afVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = afVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public af getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
