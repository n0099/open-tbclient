package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
/* loaded from: classes26.dex */
public class LoadOfficialHistoryMessage extends LoadHistoryMessage {
    public LoadOfficialHistoryMessage(LoadHistoryMessage.a aVar) {
        super(CmdConfigCustom.CMD_LOAD_HISTORY_OFFICICAL, aVar);
    }

    public LoadOfficialHistoryMessage(int i, LoadHistoryMessage.a aVar) {
        super(i, aVar);
    }
}
