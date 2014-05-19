package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LoadGroupHistoryMessage extends LoadHistoryMessage {
    public LoadGroupHistoryMessage(c cVar) {
        super(MessageTypes.CMD_LOAD_HISTORY_GROUP, cVar);
    }
}
