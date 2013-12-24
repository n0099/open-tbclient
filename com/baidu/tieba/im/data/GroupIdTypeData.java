package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupIdTypeData implements Serializable {
    public static final int GROUP_TYPE_NORMAL = 3;
    public static final int GROUP_TYPE_OFFICIAL = 4;
    public static final int GROUP_TYPE_OPERATE = 5;
    public static final int GROUP_TYPE_PERSONAL = 6;
    public static final int GROUP_TYPE_PRIVATE_CHAT = 2;
    public static final int GROUP_TYPE_SYSTEM = 1;
    private static final long serialVersionUID = 8219037456828991840L;
    private int groupId;
    private int groupType;

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
}
