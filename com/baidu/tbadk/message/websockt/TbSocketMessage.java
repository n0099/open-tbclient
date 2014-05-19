package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketMessage;
/* loaded from: classes.dex */
public abstract class TbSocketMessage extends SocketMessage {
    private int squencedId;

    protected abstract Object encode();

    public TbSocketMessage(int i, Object obj) {
        super(i, obj);
        this.squencedId = 0;
        init();
    }

    public TbSocketMessage(int i) {
        super(i);
        this.squencedId = 0;
        init();
    }

    public TbSocketMessage(int i, int i2) {
        super(i, i2);
        this.squencedId = 0;
        init();
    }

    private void init() {
    }

    @Override // com.baidu.adp.framework.message.SocketMessage
    public Object getData() {
        return encode();
    }

    @Override // com.baidu.adp.framework.message.SocketMessage
    public int getSquencedId() {
        return this.squencedId;
    }

    @Override // com.baidu.adp.framework.message.SocketMessage
    public void setSquencedId(int i) {
        this.squencedId = i;
    }
}
