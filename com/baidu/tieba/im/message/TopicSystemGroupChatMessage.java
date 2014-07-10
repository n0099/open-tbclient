package com.baidu.tieba.im.message;

import com.baidu.tieba.im.message.chat.GroupChatMessage;
/* loaded from: classes.dex */
public class TopicSystemGroupChatMessage extends GroupChatMessage {
    public String mSystemContent;
    public String mSystemMsg;

    public TopicSystemGroupChatMessage() {
        super(501126);
        setMsgType(12);
    }

    @Override // com.baidu.tieba.im.message.chat.CommonGroupChatMessage, com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        return null;
    }
}
