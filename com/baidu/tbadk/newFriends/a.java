package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class a {
    private static a ayM = new a();

    private a() {
    }

    public static a DX() {
        return ayM;
    }

    public void b(long j, long j2, String str) {
        RequestApplyMessage requestApplyMessage = new RequestApplyMessage();
        requestApplyMessage.setFriendId(j2);
        requestApplyMessage.setMessage(str);
        requestApplyMessage.setUid(j);
        MessageManager.getInstance().sendMessage(requestApplyMessage);
    }

    public void a(long j, String str, String str2) {
        RequestAddFriendMessage requestAddFriendMessage = new RequestAddFriendMessage();
        requestAddFriendMessage.setFriendId(j);
        requestAddFriendMessage.setMessage(str);
        requestAddFriendMessage.setSt_type(str2);
        MessageManager.getInstance().sendMessage(requestAddFriendMessage);
    }

    public void b(long j, String str) {
        RequestPassFriendMessage requestPassFriendMessage = new RequestPassFriendMessage();
        requestPassFriendMessage.setFriendId(j, str);
        MessageManager.getInstance().sendMessage(requestPassFriendMessage);
    }

    public void I(long j) {
        RequestDeleteFriendMessage requestDeleteFriendMessage = new RequestDeleteFriendMessage();
        requestDeleteFriendMessage.setFriendId(j);
        MessageManager.getInstance().sendMessage(requestDeleteFriendMessage);
    }
}
