package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.List;
/* loaded from: classes.dex */
public class ResponseLocalHistoryMessage extends CustomResponsedMessage<List<ba>> {
    public ResponseLocalHistoryMessage(List<ba> list) {
        super(MessageTypes.CMD_QUERY_OFFICIAL_LOCAL_HISTORY, list);
    }
}
