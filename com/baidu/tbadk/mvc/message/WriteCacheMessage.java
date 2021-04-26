package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes3.dex */
public class WriteCacheMessage<T> extends CustomMessage<T> {
    public boolean isClear;

    public WriteCacheMessage(int i2) {
        super(i2);
    }

    public boolean isClear() {
        return this.isClear;
    }

    public void setClear(boolean z) {
        this.isClear = z;
    }
}
