package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class RequestUnreadPointNum extends CustomResponsedMessage<Object> {
    public RequestUnreadPointNum() {
        super(CmdConfigCustom.CMD_REQUEST_UNREAD_NEW_FRIENDS_NUM);
    }
}
