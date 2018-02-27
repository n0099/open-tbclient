package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.task.a;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.im.c;
import com.baidu.tieba.im.c.a.i;
import com.baidu.tieba.im.c.a.j;
import com.baidu.tieba.im.c.a.k;
import com.baidu.tieba.im.c.a.l;
import com.baidu.tieba.im.c.a.m;
import com.baidu.tieba.im.c.a.n;
import com.baidu.tieba.im.c.a.o;
import com.baidu.tieba.im.c.a.p;
import com.baidu.tieba.im.c.a.q;
import com.baidu.tieba.im.c.a.r;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponsePushCountMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendPVTJMessage;
/* loaded from: classes3.dex */
public class FramworkMessageCenterHelperStatic {
    static {
        aKX();
        aKY();
        aKZ();
    }

    public static boolean aKX() {
        b(103003, ResponseGroupsByUidMessage.class, false);
        b(202101, ResponsePushCountMessage.class, false);
        b(103101, ResponseAddGroupMessage.class, false);
        b(208001, ResponseOfficialBarInfoMessage.class, false);
        b(208002, ResponseHistoryMessage.class, false);
        b(104001, ResponseSendPVTJMessage.class, false);
        b(103007, ResponseSearchGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        b(303006, ResponseOfficialBarMenuMessage.class, false);
        b(208003, ResponseSendOfficialBarMenuMessage.class, false);
        return true;
    }

    private static b b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return c.b(i, cls, z);
    }

    private static boolean aKY() {
        b(2001106, o.class);
        b(2001205, q.class);
        b(2001206, p.class);
        b(2001207, r.class);
        b(2001144, i.class);
        b(2001147, n.class);
        b(2001150, j.class);
        b(2001151, k.class);
        b(2001152, l.class);
        b(2001177, m.class);
        return true;
    }

    private static a b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        return c.b(i, cls);
    }

    private static boolean aKZ() {
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.message.a());
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.message.b());
        return true;
    }
}
