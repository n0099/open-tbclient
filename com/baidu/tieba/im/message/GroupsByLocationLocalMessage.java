package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes3.dex */
public class GroupsByLocationLocalMessage extends CustomMessage<Object> {
    public GroupsByLocationLocalMessage() {
        super(CmdConfigCustom.CMD_REQUEST_GROUP_BY_LOCATION_LOCAL);
    }
}
