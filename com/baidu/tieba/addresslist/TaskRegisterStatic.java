package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* loaded from: classes.dex */
public class TaskRegisterStatic {
    static {
        com.baidu.tieba.im.e.b(304101, ResponsePassFriendMessage.class, false);
        MessageManager.getInstance().addResponsedMessageRule(new g());
    }
}
