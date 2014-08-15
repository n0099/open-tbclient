package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class MemoryClearStrangerItemsMessage extends CustomResponsedMessage<e> {
    private boolean isAllClear;

    public MemoryClearStrangerItemsMessage(e eVar, boolean z) {
        super(2016009, eVar);
        this.isAllClear = z;
    }

    public boolean isAllClear() {
        return this.isAllClear;
    }
}
