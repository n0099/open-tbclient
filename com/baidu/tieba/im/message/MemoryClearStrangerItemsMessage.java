package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import java.util.List;
/* loaded from: classes.dex */
public class MemoryClearStrangerItemsMessage extends CustomResponsedMessage<a> {
    private boolean isAllClear;

    public MemoryClearStrangerItemsMessage(a aVar, boolean z) {
        super(CmdConfigCustom.MEMORY_REQUEST_MODIFY_LOTS_VISIBILITY, aVar);
        this.isAllClear = z;
    }

    /* loaded from: classes.dex */
    public static class a {
        public List<MemoryModifyVisibilityMessage.a> eEh;

        public a(List<MemoryModifyVisibilityMessage.a> list) {
            this.eEh = list;
        }
    }

    public boolean isAllClear() {
        return this.isAllClear;
    }
}
