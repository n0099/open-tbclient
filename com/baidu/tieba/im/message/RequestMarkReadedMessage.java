package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class RequestMarkReadedMessage extends CustomMessage<String> {
    public RequestMarkReadedMessage() {
        super(MessageTypes.CMD_GROUP_MARK_READED);
    }
}
