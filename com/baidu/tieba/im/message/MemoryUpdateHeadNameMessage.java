package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class MemoryUpdateHeadNameMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public int customGroupType;
        public String head;
        public String id;
        public String name;
    }

    public MemoryUpdateHeadNameMessage(a aVar) {
        super(2016017, aVar);
    }
}
