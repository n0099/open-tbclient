package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class MemoryInitCompleteMessage extends CustomResponsedMessage<Boolean> {
    public MemoryInitCompleteMessage(boolean z) {
        super(2016002, Boolean.valueOf(z));
    }
}
