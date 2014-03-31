package com.baidu.tieba.im.groupInfo;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupSettingItemData extends com.baidu.tieba.im.pushNotify.l implements Serializable {
    private static final long serialVersionUID = -3083517174627940892L;
    private String gid;
    private boolean isAlreadyApply;
    private boolean isHide;
    private boolean isInGroup;
    private boolean isUseHeadSet;
    private long lastApplyTimeStamp;
    private String uid;

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
