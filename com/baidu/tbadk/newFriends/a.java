package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class a {
    private static a a = new a();

    private a() {
    }

    public static a a() {
        return a;
    }

    public void a(long j, String str) {
        RequestAddFriendMessage requestAddFriendMessage = new RequestAddFriendMessage();
        requestAddFriendMessage.setFriendId(j);
        requestAddFriendMessage.setMessage(str);
        MessageManager.getInstance().sendMessage(requestAddFriendMessage);
    }

    public void b(long j, String str) {
        RequestPassFriendMessage requestPassFriendMessage = new RequestPassFriendMessage();
        requestPassFriendMessage.setFriendId(j, str);
        MessageManager.getInstance().sendMessage(requestPassFriendMessage);
    }

    public void a(long j) {
        RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
        requestDeleteFriendMessage.setFriendId(j);
        MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
    }
}
