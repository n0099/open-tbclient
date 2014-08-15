package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupIdTypeData implements Serializable {
    private static final long serialVersionUID = 8219037456828991840L;
    private int groupId;
    private int groupType;
    private int mCustomType = 1;

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    public int getCustomType() {
        return this.mCustomType;
    }

    public void setCustomType(int i) {
        this.mCustomType = i;
    }
}
