package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.lib.a.b.a.a.i;
/* loaded from: classes.dex */
public class a extends i {
    protected String draft;
    protected boolean isAcceptNotify;

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public String getDraft() {
        return this.draft;
    }

    public void setDraft(String str) {
        this.draft = str;
    }
}
