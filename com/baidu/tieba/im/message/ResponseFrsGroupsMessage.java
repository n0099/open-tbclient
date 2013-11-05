package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseFrsGroupsMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5970126981799423191L;
    private GroupPermData groupPerm;
    private List<GroupInfoData> groups;

    public ResponseFrsGroupsMessage() {
    }

    public ResponseFrsGroupsMessage(int i) {
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
