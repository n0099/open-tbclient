package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class a {
    public static void h(long j, String str) {
        RequestPassFriendMessage requestPassFriendMessage = new RequestPassFriendMessage();
        requestPassFriendMessage.setFriendId(j, str);
        MessageManager.getInstance().sendMessage(requestPassFriendMessage);
    }
}
