package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class FrsHotThreadRequestCacheMessage extends CustomMessage<String> {
    public FrsHotThreadRequestCacheMessage(String str) {
        super((int) CmdConfigCustom.CMD_FRS_HOT_CACHE, str);
    }
}
