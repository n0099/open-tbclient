package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.br;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.ad;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.t;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.y;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.z;
import com.baidu.tieba.im.message.GroupMsgArrivedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q {
    private static q a = null;
    private String c;
    private ArrayList<CustomMessageListener> b = new ArrayList<>();
    private com.baidu.adp.framework.listener.b d = new r(this, 202006);

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (a == null) {
                a = new q();
            }
            qVar = a;
        }
        return qVar;
    }

    public void b() {
        f();
    }

    private q() {
    }

    private void f() {
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.f());
        MessageManager.getInstance().registerListener(new t());
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.k());
        MessageManager.getInstance().registerListener(new ad());
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.o());
        MessageManager.getInstance().registerListener(new y());
        MessageManager.getInstance().registerListener(new z());
        MessageManager.getInstance().registerListener(new com.baidu.tieba.im.chat.receiveChatMsgHandler.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new br(TbadkApplication.m252getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000999, pushNotifyMessage.getContent()));
            } else {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                TiebaStatic.imLog(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
                if (!TextUtils.isEmpty(valueOf)) {
                    com.baidu.tieba.im.c.b.b().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                }
            }
        }
    }

    public void c() {
        com.baidu.tieba.im.c.b.b().h();
    }

    public void d() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupMsgArrivedMessage());
    }

    public String e() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
