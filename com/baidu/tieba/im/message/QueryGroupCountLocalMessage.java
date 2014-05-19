package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class QueryGroupCountLocalMessage extends CustomMessage<Object> {
    public QueryGroupCountLocalMessage() {
        super(MessageTypes.CMD_REQUEST_GROUP_COUNT_LOCAL);
    }
}
