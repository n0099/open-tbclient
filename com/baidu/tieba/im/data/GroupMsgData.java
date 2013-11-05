package com.baidu.tieba.im.data;

import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public class GroupMsgData extends Message {
    private GroupIdTypeData groupInfo;
    private b listMessage;

    public GroupMsgData(int i) {
        super.setCmd(i);
    }

    public GroupIdTypeData getGroupInfo() {
        return this.groupInfo;
    }

    public void setGroupInfo(GroupIdTypeData groupIdTypeData) {
        this.groupInfo = groupIdTypeData;
    }

    public b getListMessage() {
        return this.listMessage;
    }

    public void setListMessageData(b bVar) {
        this.listMessage = bVar;
    }
}
