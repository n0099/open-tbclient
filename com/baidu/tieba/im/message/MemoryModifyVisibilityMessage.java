package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {
    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int customGroupType;
        public String id;
        public boolean visible;

        public a(String str, int i, boolean z) {
            this.id = str;
            this.customGroupType = i;
            this.visible = z;
        }
    }
}
