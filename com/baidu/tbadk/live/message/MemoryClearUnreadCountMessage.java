package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class MemoryClearUnreadCountMessage extends CustomResponsedMessage<a> {
    public MemoryClearUnreadCountMessage(a aVar) {
        super(2016006, aVar);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int customGroupType;
        public String id;

        public a(String str, int i) {
            this.id = str;
            this.customGroupType = i;
        }
    }
}
