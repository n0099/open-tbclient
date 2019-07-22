package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.push.PushResponseMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    public static void init() {
        bzC();
        bzD();
    }

    private static void bzC() {
        c.b(104102, ResponseUpdateMaskInfoMessage.class, false);
        c.b(202003, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(202009, PushResponseMessage.class, false);
        c.b(202006, PushNotifyMessageDecoder.class, false);
        c.b(104103, ResponseGetMaskInfoMessage.class, false);
        c.b(304100, ResponseAddFriendMessage.class, false);
        c.b(304102, ResponseDeleteFriendMessage.class, false);
        c.b(304103, ResponseApplyMessage.class, false);
        c.b(205002, ResponseCommitInviteMessage.class, false);
        c.b(104104, ResponseCheckUserMaskMessage.class, false);
        MessageManager.getInstance().registerStickyMode(2001120);
    }

    private static boolean bzD() {
        MessageManager.getInstance().addResponsedMessageRule(new j(202006) { // from class: com.baidu.tieba.im.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.g
            /* renamed from: d */
            public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof PushNotifyMessageDecoder) {
                    PushNotifyMessageDecoder pushNotifyMessageDecoder = (PushNotifyMessageDecoder) socketResponsedMessage;
                    if (pushNotifyMessageDecoder.getMsgList() != null) {
                        Iterator<PushNotifyMessage> it = pushNotifyMessageDecoder.getMsgList().iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(it.next());
                        }
                    }
                }
                return socketResponsedMessage;
            }
        });
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.a.d());
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.push.d());
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.im.a.c());
        return true;
    }
}
