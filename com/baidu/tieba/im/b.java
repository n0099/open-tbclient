package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
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
        cIn();
        cIo();
    }

    private static void cIn() {
        c.b(CmdConfigSocket.CMD_UPDATE_MASK_INFO, ResponseUpdateMaskInfoMessage.class, false);
        c.b(CmdConfigSocket.CMD_MESSAGE_SYNC, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(CmdConfigSocket.CMD_PUSH_MESSAGE, PushResponseMessage.class, false);
        c.b(CmdConfigSocket.CMD_PUSH_NOTIFY, PushNotifyMessageDecoder.class, false);
        c.b(CmdConfigSocket.CMD_GET_MASK_INFO, ResponseGetMaskInfoMessage.class, false);
        c.b(CmdConfigSocket.CMD_ADD_NEW_FRIEND, ResponseAddFriendMessage.class, false);
        c.b(CmdConfigSocket.CMD_DELETE_NEW_FRIEND, ResponseDeleteFriendMessage.class, false);
        c.b(CmdConfigSocket.CMD_APPLY_MESSAGE, ResponseApplyMessage.class, false);
        c.b(CmdConfigSocket.CMD_COMMIT_INVITE, ResponseCommitInviteMessage.class, false);
        c.b(CmdConfigSocket.CMD_CHECK_USER_MASK, ResponseCheckUserMaskMessage.class, false);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
    }

    private static boolean cIo() {
        MessageManager.getInstance().addResponsedMessageRule(new j(CmdConfigSocket.CMD_PUSH_NOTIFY) { // from class: com.baidu.tieba.im.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.b.g
            /* renamed from: e */
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
