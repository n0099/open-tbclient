package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class MemoryClearStrangerItemsMessage extends CustomResponsedMessage<a> {
    public boolean isAllClear;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<MemoryModifyVisibilityMessage.a> f18046a;
    }

    public MemoryClearStrangerItemsMessage(a aVar, boolean z) {
        super(2016009, aVar);
        this.isAllClear = z;
    }

    public boolean isAllClear() {
        return this.isAllClear;
    }
}
