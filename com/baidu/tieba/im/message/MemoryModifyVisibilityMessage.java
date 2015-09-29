package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {
    public MemoryModifyVisibilityMessage(a aVar) {
        super(CmdConfigCustom.MEMORY_MODIFY_VISIBILITY, aVar);
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
