package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.t;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.u;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.y;
import com.baidu.tieba.im.message.GroupMsgArrivedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class o {
    private static o a = null;
    private String c;
    private ArrayList<com.baidu.adp.framework.c.a> b = new ArrayList<>();
    private com.baidu.adp.framework.c.g d = new p(this, 202006);

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (a == null) {
                a = new o();
            }
            oVar = a;
        }
        return oVar;
    }

    public final void b() {
        com.baidu.adp.framework.c.a().a(this.d);
        com.baidu.adp.framework.c.a().a(new com.baidu.tieba.im.chat.receiveChatMsgHandler.f());
        com.baidu.adp.framework.c.a().a(new com.baidu.tieba.im.chat.receiveChatMsgHandler.o());
        com.baidu.adp.framework.c.a().a(new com.baidu.tieba.im.chat.receiveChatMsgHandler.g());
        com.baidu.adp.framework.c.a().a(new y());
        com.baidu.adp.framework.c.a().a(new com.baidu.tieba.im.chat.receiveChatMsgHandler.k());
        com.baidu.adp.framework.c.a().a(new t());
        com.baidu.adp.framework.c.a().a(new u());
    }

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(o oVar, PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            com.baidu.adp.lib.util.f.e("cmd: " + pushNotifyMessage.g() + "groupId: " + pushNotifyMessage.k());
            if (pushNotifyMessage.d() == 3) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new ar(TbadkApplication.j())));
                return;
            }
            String valueOf = String.valueOf(pushNotifyMessage.k());
            TiebaStatic.a(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
            if (TextUtils.isEmpty(valueOf)) {
                return;
            }
            com.baidu.tieba.im.c.b.a().a(pushNotifyMessage.k(), pushNotifyMessage.j(), pushNotifyMessage.i());
        }
    }

    public static void c() {
        com.baidu.tieba.im.c.b.a().g();
    }

    public static void d() {
        com.baidu.adp.framework.c.a().b(new GroupMsgArrivedMessage());
        com.baidu.adp.lib.util.f.e("dispatch group chat ");
    }

    public final String e() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }
}
