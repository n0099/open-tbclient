package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* loaded from: classes15.dex */
public class LoadGroupHistoryMessage extends LoadHistoryMessage {
    public LoadGroupHistoryMessage(LoadHistoryMessage.a aVar) {
        super(CmdConfigCustom.CMD_LOAD_HISTORY_GROUP, aVar);
    }
}
