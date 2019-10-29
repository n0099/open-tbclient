package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes3.dex */
public class GroupMsgArrivedMessage extends CustomResponsedMessage<Object> {
    public GroupMsgArrivedMessage() {
        super(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_MSG_ARRIVED);
    }
}
