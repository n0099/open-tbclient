package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LoadPersonalHistoryMessage extends LoadHistoryMessage {
    public LoadPersonalHistoryMessage(c cVar) {
        super(MessageTypes.CMD_LOAD_HISTORY_PERSONAL, cVar);
    }
}
