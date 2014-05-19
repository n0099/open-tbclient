package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupsByUidLocalMessage extends CustomMessage<Object> {
    public GroupsByUidLocalMessage() {
        super(MessageTypes.CMD_REQUEST_GROUP_BY_UID_LOCAL);
    }
}
