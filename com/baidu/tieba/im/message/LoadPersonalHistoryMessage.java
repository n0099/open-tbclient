package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* loaded from: classes.dex */
public class LoadPersonalHistoryMessage extends LoadHistoryMessage {
    public LoadPersonalHistoryMessage(LoadHistoryMessage.a aVar) {
        super(CmdConfigCustom.CMD_LOAD_HISTORY_PERSONAL, aVar);
    }
}
