package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketMessage;
/* loaded from: classes3.dex */
public abstract class TbSocketMessage extends SocketMessage {
    public TbSocketMessage(int i, Object obj) {
        super(i, obj);
        init();
    }

    private void init() {
    }

    public abstract Object encode();

    @Override // com.baidu.adp.framework.message.SocketMessage
    public Object getData() {
        return encode();
    }

    public TbSocketMessage(int i) {
        super(i);
        init();
    }

    public TbSocketMessage(int i, int i2) {
        super(i, Integer.valueOf(i2));
        init();
    }
}
