package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LiveChatRoomEventResponseMessage extends CustomResponsedMessage<String> {
    public LiveChatRoomEventResponseMessage(String str) {
        super(MessageTypes.CMD_LIVE_CHAT_ROOM_EVENT, str);
    }
}
