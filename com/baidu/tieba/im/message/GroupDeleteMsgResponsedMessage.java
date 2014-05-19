package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupDeleteMsgResponsedMessage extends CustomResponsedMessage<Object> {
    public GroupDeleteMsgResponsedMessage() {
        super(MessageTypes.CMD_DELETE_MSG);
    }
}
