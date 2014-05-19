package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class ResponseShowedSpringEggMessage extends CustomResponsedMessage<Object> {
    public ResponseShowedSpringEggMessage() {
        super(MessageTypes.CMD_SHOW_SPRING_EGG);
    }
}
