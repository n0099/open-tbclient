package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.task.a;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.e;
import com.baidu.tieba.im.e.a.i;
import com.baidu.tieba.im.e.a.j;
import com.baidu.tieba.im.e.a.k;
import com.baidu.tieba.im.e.a.l;
import com.baidu.tieba.im.e.a.m;
import com.baidu.tieba.im.e.a.n;
import com.baidu.tieba.im.e.a.o;
import com.baidu.tieba.im.e.a.p;
import com.baidu.tieba.im.e.a.q;
import com.baidu.tieba.im.e.a.r;
import com.baidu.tieba.im.memorycache.bv;
import com.baidu.tieba.im.memorycache.by;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponsePushCountMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendPVTJMessage;
/* loaded from: classes.dex */
public class FramworkMessageCenterHelperStatic {
    static {
        Sz();
        SA();
        SB();
    }

    public static boolean Sz() {
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
        return e.b(i, cls, z);
    }

    private static boolean SA() {
        b(2001106, o.class);
        b(2001211, q.class);
        b(2001212, p.class);
        b(2001213, r.class);
        b(2001148, i.class);
        b(2001151, n.class);
        b(2001154, j.class);
        b(2001155, k.class);
        b(2001156, l.class);
        b(2001181, m.class);
        return true;
    }

    private static a b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        return e.b(i, cls);
    }

    private static boolean SB() {
        MessageManager.getInstance().addResponsedMessageRule(new bv());
        MessageManager.getInstance().addResponsedMessageRule(new by());
        return true;
    }
}
