package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUploadClientLogMessage;
import com.baidu.tieba.im.push.PushResponseMessage;
import com.baidu.tieba.im.push.h;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
/* loaded from: classes.dex */
public class IMTaskRegisterStatic {
    static {
        aky();
        akz();
        akA();
    }

    private static void aky() {
        f.b(104102, ResponseUpdateMaskInfoMessage.class, false);
        f.b(202003, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        f.b(202009, PushResponseMessage.class, false);
        f.b(202006, PushNotifyMessageDecoder.class, false);
        f.b(104103, ResponseGetMaskInfoMessage.class, false);
        f.b(304100, ResponseAddFriendMessage.class, false);
        f.b(304102, ResponseDeleteFriendMessage.class, false);
        f.b(304103, ResponseApplyMessage.class, false);
        f.b(202005, ResponseUploadClientLogMessage.class, false);
        f.b(205002, ResponseCommitInviteMessage.class, false);
        f.b(104104, ResponseCheckUserMaskMessage.class, false);
    }

    private static void akz() {
    }

    private static boolean akA() {
        MessageManager.getInstance().addResponsedMessageRule(new g(202006));
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.b.j());
        MessageManager.getInstance().addResponsedMessageRule(new h());
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.im.b.i());
        return true;
    }
}
