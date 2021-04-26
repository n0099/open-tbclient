package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class GroupIdTypeData implements Serializable {
    public static final long serialVersionUID = 8219037456828991840L;
    public long groupId;
    public int groupType;
    public int mCustomType = 1;
    public int userType;

    public int getCustomType() {
        return this.mCustomType;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setCustomType(int i2) {
        this.mCustomType = i2;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupType(int i2) {
        this.groupType = i2;
    }

    public void setUserType(int i2) {
        this.userType = i2;
    }
}
