package com.baidu.tieba.im.chat.personaltalk;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PersonalSettingItemData implements com.baidu.tieba.im.c.k, Serializable {
    private static final long serialVersionUID = 6507309561121772239L;
    private String draft;
    private boolean isAcceptNotify;
    private boolean isHide;
    private String myUid;
    private String toName;
    private String toPortrait;
    private String toUid;

    public String getMyUid() {
        return this.myUid;
    }

    public void setMyUid(String str) {
        this.myUid = str;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    @Override // com.baidu.tieba.im.c.k
    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }

    public String getDraft() {
        return this.draft;
    }

    public void setDraft(String str) {
        this.draft = str;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public String getToName() {
        return this.toName;
    }

    public void setToName(String str) {
        this.toName = str;
    }

    public String getToPortrait() {
        return this.toPortrait;
    }

    public void setToPortrait(String str) {
        this.toPortrait = str;
    }
}
