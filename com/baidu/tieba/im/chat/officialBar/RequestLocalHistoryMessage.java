package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class RequestLocalHistoryMessage extends CustomMessage<String> {
    public RequestLocalHistoryMessage(String str) {
        super((int) MessageTypes.CMD_QUERY_OFFICIAL_LOCAL_HISTORY, str);
    }
}
