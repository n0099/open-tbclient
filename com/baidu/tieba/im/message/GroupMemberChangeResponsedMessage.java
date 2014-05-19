package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupMemberChangeResponsedMessage extends CustomResponsedMessage<String> {
    public GroupMemberChangeResponsedMessage(String str) {
        super(MessageTypes.CMD_GROUP_MEMBER_CHANGE, str);
    }
}
