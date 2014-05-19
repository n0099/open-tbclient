package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
/* loaded from: classes.dex */
public class PingMessage extends TbSocketMessage {
    public PingMessage() {
        super(MessageTypes.CMD_PING);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        return null;
    }
}
