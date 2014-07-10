package com.baidu.tieba.im.message;

import com.baidu.tieba.im.message.chat.GroupChatMessage;
/* loaded from: classes.dex */
public class FakeSystemGroupChatMessage extends GroupChatMessage {
    public String mSystemMsg;

    public FakeSystemGroupChatMessage() {
        setMsgType(13);
    }

    @Override // com.baidu.tieba.im.message.chat.CommonGroupChatMessage, com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        return null;
    }
}
