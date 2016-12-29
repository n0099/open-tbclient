package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ad;
/* loaded from: classes.dex */
public class k {
    private String forumId;
    private ad mGraffitiInfo;
    private String threadId;

    public k(String str, String str2, ad adVar) {
        this.forumId = str;
        this.threadId = str2;
        this.mGraffitiInfo = adVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ad getGraffitiInfo() {
        return this.mGraffitiInfo;
    }
}
