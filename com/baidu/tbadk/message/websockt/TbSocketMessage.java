package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketMessage;
/* loaded from: classes3.dex */
public abstract class TbSocketMessage extends SocketMessage {
    public TbSocketMessage(int i2, Object obj) {
        super(i2, obj);
        init();
    }

    private void init() {
    }

    public abstract Object encode();

    @Override // com.baidu.adp.framework.message.SocketMessage
    public Object getData() {
        return encode();
    }

    public TbSocketMessage(int i2) {
        super(i2);
        init();
    }

    public TbSocketMessage(int i2, int i3) {
        super(i2, Integer.valueOf(i3));
        init();
    }
}
