package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.ac;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.s;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.x;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.y;
import com.baidu.tieba.im.message.GroupMsgArrivedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p {
    private static p a = null;
    private String c;
    private ArrayList<CustomMessageListener> b = new ArrayList<>();
    private com.baidu.adp.framework.listener.b d = new q(this, MessageTypes.CMD_PUSH_NOTIFY);

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (a == null) {
                a = new p();
            }
            pVar = a;
        }
        return pVar;
    }

    public void b() {
        f();
    }

    private p() {
    }

    private void f() {
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.f());
        MessageManager.getInstance().registerListener(new s());
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.k());
        MessageManager.getInstance().registerListener(new ac());
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.o());
        MessageManager.getInstance().registerListener(new x());
        MessageManager.getInstance().registerListener(new y());
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            BdLog.d("cmd: " + pushNotifyMessage.getCmd() + "groupId: " + pushNotifyMessage.getGroupId());
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new bd(TbadkApplication.m252getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfig.CMD_DEBUGLOG_SPECIFIED, pushNotifyMessage.getContent()));
            } else {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                TiebaStatic.imLog(MessageTypes.CMD_PUSH_NOTIFY, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
                if (!TextUtils.isEmpty(valueOf)) {
                    com.baidu.tieba.im.c.b.a().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                }
            }
        }
    }

    public void c() {
        com.baidu.tieba.im.c.b.a().g();
    }

    public void d() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupMsgArrivedMessage());
        BdLog.d("dispatch group chat ");
    }

    public String e() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
