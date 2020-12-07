package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes26.dex */
public class RequestLocalHistoryMessage extends CustomMessage<String> {
    public RequestLocalHistoryMessage(String str) {
        super((int) CmdConfigCustom.CMD_QUERY_OFFICIAL_LOCAL_HISTORY, str);
    }
}
