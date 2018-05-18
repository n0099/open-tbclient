package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MemoryClearStrangerItemsMessage extends CustomResponsedMessage<a> {
    private boolean isAllClear;

    /* loaded from: classes.dex */
    public static class a {
        public List<MemoryModifyVisibilityMessage.a> eer;
    }

    public MemoryClearStrangerItemsMessage(a aVar, boolean z) {
        super(2016009, aVar);
        this.isAllClear = z;
    }

    public boolean isAllClear() {
        return this.isAllClear;
    }
}
