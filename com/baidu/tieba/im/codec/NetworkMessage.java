package com.baidu.tieba.im.codec;

import com.baidu.tieba.im.message.AckedMessage;
import com.baidu.tieba.im.message.Message;
import java.io.Serializable;
/* loaded from: classes.dex */
public class NetworkMessage implements Serializable {
    private Message data;
    private AckedMessage.MessageTag msgTag;

    public NetworkMessage(Message message) {
        this.data = message;
    }

    public int getCmd() {
        if (this.data == null) {
            return 0;
        }
        return this.data.getCmd();
    }

    public Message getData() {
        return this.data;
    }

    public void setData(Message message) {
        this.data = message;
    }

    public AckedMessage.MessageTag getMsgTag() {
        return this.msgTag;
    }

    public void setMsgTag(AckedMessage.MessageTag messageTag) {
        this.msgTag = messageTag;
    }
}
