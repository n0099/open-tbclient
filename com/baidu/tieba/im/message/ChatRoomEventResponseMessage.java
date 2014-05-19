package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class ChatRoomEventResponseMessage extends CustomResponsedMessage<String> {
    public ChatRoomEventResponseMessage(String str) {
        super(MessageTypes.CMD_CHAT_ROOM_EVENT, str);
    }
}
