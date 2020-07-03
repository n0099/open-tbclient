package com.baidu.tieba.hottopicselect;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes8.dex */
public class HotSelectCacheReqMessage extends CustomMessage<Object> {
    public HotSelectCacheReqMessage(int i) {
        super(i);
    }

    public HotSelectCacheReqMessage() {
        super(CmdConfigCustom.CMD_HOT_TOPIC_SELECT_CACHE);
    }
}
