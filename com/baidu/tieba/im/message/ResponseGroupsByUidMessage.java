package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseGroupsByUidMessage extends ResponsedMessage {
    private static final long serialVersionUID = -536206550195962676L;
    private GroupPermData groupPerm;
    private List<GroupInfoData> groups;

    public ResponseGroupsByUidMessage() {
    }

    public ResponseGroupsByUidMessage(int i) {
        super(i);
    }

    public List<GroupInfoData> getGroups() {
        return this.groups;
    }

    public void setGroups(List<GroupInfoData> list) {
        this.groups = list;
    }

    public GroupPermData getGroupPerm() {
        return this.groupPerm;
    }

    public void setGroupPerm(GroupPermData groupPermData) {
        this.groupPerm = groupPermData;
    }
}
