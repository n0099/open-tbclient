package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes3.dex */
public class ChatSetting extends OrmObject {
    public String draft;
    public boolean isAcceptNotify;

    public String getDraft() {
        return this.draft;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }

    public void setDraft(String str) {
        this.draft = str;
    }
}
