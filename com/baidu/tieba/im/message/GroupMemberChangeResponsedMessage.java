package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class GroupMemberChangeResponsedMessage extends CustomResponsedMessage<String> {
    public GroupMemberChangeResponsedMessage(String str) {
        super(CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE, str);
    }
}
