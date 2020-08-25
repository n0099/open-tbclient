package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes2.dex */
public class a {
    public static void g(long j, String str) {
        RequestPassFriendMessage requestPassFriendMessage = new RequestPassFriendMessage();
        requestPassFriendMessage.setFriendId(j, str);
        MessageManager.getInstance().sendMessage(requestPassFriendMessage);
    }
}
