package com.baidu.tieba.im.settingcache;

import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class GroupSettingItemData extends ChatSetting implements Serializable {
    public static final long serialVersionUID = -3083517174627940892L;
    public String gid;
    public boolean isAlreadyApply;
    public boolean isHide;
    public boolean isInGroup;
    public boolean isUseHeadSet;
    public long lastApplyTimeStamp;
    public String uid;

    public String getGid() {
        return this.gid;
    }

    public long getLastApplyTimeStamp() {
        return this.lastApplyTimeStamp;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isAlreadyApply() {
        return this.isAlreadyApply;
    }

    public boolean isHide() {
        return this.isHide;
    }

    public boolean isInGroup() {
        return this.isInGroup;
    }

    public boolean isUseHeadSet() {
        return this.isUseHeadSet;
    }

    public void setAlreadyApply(boolean z) {
        this.isAlreadyApply = z;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public void setHide(boolean z) {
        this.isHide = z;
    }

    public void setInGroup(boolean z) {
        this.isInGroup = z;
    }

    public void setLastApplyTimeStamp(long j) {
        this.lastApplyTimeStamp = j;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUseHeadSet(boolean z) {
        this.isUseHeadSet = z;
    }
}
