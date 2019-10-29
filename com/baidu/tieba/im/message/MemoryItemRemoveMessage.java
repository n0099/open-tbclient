package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class MemoryItemRemoveMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public int customGroupType;
        public String id;
    }

    public MemoryItemRemoveMessage(a aVar) {
        super(CmdConfigCustom.MEMORY_REMOVE_ITEM, aVar);
    }
}
