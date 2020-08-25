package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes2.dex */
public class ChatSetting extends OrmObject {
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
