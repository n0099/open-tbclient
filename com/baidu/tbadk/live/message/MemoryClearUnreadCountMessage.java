package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class MemoryClearUnreadCountMessage extends CustomResponsedMessage<a> {
    public MemoryClearUnreadCountMessage(a aVar) {
        super(CmdConfigCustom.MEMORY_MODIFY_UNREAD_COUNT, aVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int customGroupType;
        public String id;

        public a(String str, int i) {
            this.id = str;
            this.customGroupType = i;
        }
    }
}
