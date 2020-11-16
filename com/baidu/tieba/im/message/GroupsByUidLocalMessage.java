package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes25.dex */
public class GroupsByUidLocalMessage extends CustomMessage<Object> {
    public GroupsByUidLocalMessage() {
        super(CmdConfigCustom.CMD_REQUEST_GROUP_BY_UID_LOCAL);
    }
}
