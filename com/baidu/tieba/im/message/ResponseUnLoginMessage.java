package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class ResponseUnLoginMessage extends CustomResponsedMessage<Object> {
    public ResponseUnLoginMessage() {
        super(MessageTypes.CMD_UN_LOGIN);
    }
}
