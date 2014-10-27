package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class WriteCacheMessage<T> extends CustomMessage<T> {
    private boolean isClear;

    public WriteCacheMessage(int i) {
        super(i);
    }

    public boolean isClear() {
        return this.isClear;
    }

    public void setClear(boolean z) {
        this.isClear = z;
    }
}
