package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class MemoryInitCompleteMessage extends CustomResponsedMessage<Boolean> {
    public MemoryInitCompleteMessage(boolean z) {
        super(CmdConfigCustom.MEMORY_INIT_COMPLETED, Boolean.valueOf(z));
    }
}
