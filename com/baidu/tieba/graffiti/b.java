package com.baidu.tieba.graffiti;

import com.baidu.tbadk.core.data.ae;
/* loaded from: classes.dex */
public class b {
    private ae cnu;
    private String forumId;
    private String threadId;

    public b(String str, String str2, ae aeVar) {
        this.forumId = str;
        this.threadId = str2;
        this.cnu = aeVar;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ae agC() {
        return this.cnu;
    }
}
