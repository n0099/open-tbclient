package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupsByLocationLocalMessage extends CustomMessage<Object> {
    public GroupsByLocationLocalMessage() {
        super(MessageTypes.CMD_REQUEST_GROUP_BY_LOCATION_LOCAL);
    }
}
