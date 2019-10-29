package com.baidu.tieba.im.message.chat;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
/* loaded from: classes.dex */
public class GroupChatMessage extends CommonGroupChatMessage {
    public GroupChatMessage() {
        super(CmdConfigSocket.CMD_GROUP_CHAT_MSG);
    }

    public GroupChatMessage(int i) {
        super(i);
    }
}
