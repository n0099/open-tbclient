package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestUnreadPointNum extends CustomResponsedMessage<Object> {
    public RequestUnreadPointNum() {
        super(CmdConfigCustom.CMD_REQUEST_UNREAD_NEW_FRIENDS_NUM);
    }
}
