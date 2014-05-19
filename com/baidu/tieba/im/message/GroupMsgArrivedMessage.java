package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupMsgArrivedMessage extends CustomResponsedMessage<Object> {
    public GroupMsgArrivedMessage() {
        super(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_MSG_ARRIVED);
    }
}
