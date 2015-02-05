package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.im.b.k;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUploadClientLogMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
/* loaded from: classes.dex */
public class IMTaskRegisterStatic {
    static {
        JV();
        JW();
        JX();
    }

    private static void JV() {
        e.b(104102, ResponseUpdateMaskInfoMessage.class, false);
        e.b(202003, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        e.b(202006, PushNotifyMessageDecoder.class, false);
        e.b(104103, ResponseGetMaskInfoMessage.class, false);
        e.b(304100, ResponseAddFriendMessage.class, false);
        e.b(304102, ResponseDeleteFriendMessage.class, false);
        e.b(304103, ResponseApplyMessage.class, false);
        e.b(202005, ResponseUploadClientLogMessage.class, false);
        e.b(205002, ResponseCommitInviteMessage.class, false);
        e.b(104104, ResponseCheckUserMaskMessage.class, false);
    }

    private static void JW() {
    }

    private static boolean JX() {
        MessageManager.getInstance().addResponsedMessageRule(new f(202006));
        MessageManager.getInstance().addResponsedMessageRule(new k());
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.im.b.j());
        return true;
    }
}
