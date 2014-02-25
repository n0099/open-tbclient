package com.baidu.tieba.im.groupInfo;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupSettingItemData implements com.baidu.tieba.im.c.i, Serializable {
    private static final long serialVersionUID = -3083517174627940892L;
    private String draft;
    private String gid;
    private boolean isAcceptNotify;
    private boolean isAlreadyApply;
    private boolean isHide;
    private boolean isInGroup;
    private boolean isUseHeadSet;
    private long lastApplyTimeStamp;
    private String uid;

    public String getDraft() {
        return this.draft;
    }

    public void setDraft(String str) {
        this.draft = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public boolean isUseHeadSet() {
        return this.isUseHeadSet;
    }

    public void setUseHeadSet(boolean z) {
        this.isUseHeadSet = z;
    }

    @Override // com.baidu.tieba.im.c.i
    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }

    public boolean isAlreadyApply() {
        return this.isAlreadyApply;
    }

    public void setAlreadyApply(boolean z) {
        this.isAlreadyApply = z;
    }

    public long getLastApplyTimeStamp() {
        return this.lastApplyTimeStamp;
    }

    public void setLastApplyTimeStamp(long j) {
        this.lastApplyTimeStamp = j;
    }

    public boolean isInGroup() {
        return this.isInGroup;
    }

    public void setInGroup(boolean z) {
        this.isInGroup = z;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }
}
