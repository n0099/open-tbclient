package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
/* loaded from: classes3.dex */
public class PingMessage extends TbSocketMessage {
    public PingMessage() {
        super(1003);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        return null;
    }
}
