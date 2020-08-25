package com.baidu.tieba.im.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class GroupMsgData extends CustomResponsedMessage<Object> {
    private GroupIdTypeData groupInfo;
    private boolean hasMore;
    private LinkedList<ChatMessage> listMessage;

    public GroupMsgData(int i) {
        super(i);
        this.groupInfo = new GroupIdTypeData();
        this.listMessage = new LinkedList<>();
    }

    public GroupIdTypeData getGroupInfo() {
        return this.groupInfo;
    }

    public void setGroupInfo(GroupIdTypeData groupIdTypeData) {
        this.groupInfo = groupIdTypeData;
    }

    public LinkedList<ChatMessage> getListMessage() {
        return this.listMessage;
    }

    public void setListMessageData(LinkedList<ChatMessage> linkedList) {
        this.listMessage = linkedList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }
}
