package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* loaded from: classes.dex */
public class LoadGroupHistoryMessage extends LoadHistoryMessage {
    public LoadGroupHistoryMessage(LoadHistoryMessage.a aVar) {
        super(CmdConfigCustom.CMD_LOAD_HISTORY_GROUP, aVar);
    }
}
