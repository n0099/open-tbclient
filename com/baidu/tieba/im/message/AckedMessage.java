package com.baidu.tieba.im.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class AckedMessage extends Message {
    private boolean isAck;
    private MessageTag msgTag;

    public MessageTag getMsgTag() {
        return this.msgTag;
    }

    public void setMsgTag(MessageTag messageTag) {
        this.msgTag = messageTag;
    }

    public boolean isAck() {
        return this.isAck;
    }

    public void setAck(boolean z) {
        this.isAck = z;
    }

    /* loaded from: classes.dex */
    public class MessageTag implements Serializable {
        private int sequence;

        public int getSequence() {
            return this.sequence;
        }

        public void setSequence(int i) {
            this.sequence = i;
        }

        public Map<String, String> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("sequence", String.valueOf(getSequence()));
            return hashMap;
        }
    }
}
