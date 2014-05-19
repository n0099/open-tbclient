package com.baidu.tieba.im.message.chat;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupChatMessage extends CommonGroupChatMessage {
    public GroupChatMessage() {
        super(MessageTypes.CMD_GROUP_CHAT_MSG);
    }

    public GroupChatMessage(int i) {
        super(i);
    }
}
