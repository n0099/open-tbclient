package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.live.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.d.a.j;
import com.baidu.tieba.im.d.a.k;
import com.baidu.tieba.im.d.a.l;
import com.baidu.tieba.im.d.a.m;
import com.baidu.tieba.im.d.a.n;
import com.baidu.tieba.im.d.a.o;
import com.baidu.tieba.im.d.a.p;
import com.baidu.tieba.im.d.a.q;
import com.baidu.tieba.im.d.a.r;
import com.baidu.tieba.im.d.a.s;
import com.baidu.tieba.im.e;
import com.baidu.tieba.im.memorycache.by;
import com.baidu.tieba.im.memorycache.ca;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponsePushCountMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendPVTJMessage;
/* loaded from: classes.dex */
public class FramworkMessageCenterHelperStatic {
    static {
        QO();
        QP();
        QQ();
    }

    public static boolean QO() {
        b(103004, ResponseGroupInfoMessage.class, false);
        b(103003, ResponseGroupsByUidMessage.class, false);
        b(202101, ResponsePushCountMessage.class, false);
        b(103101, ResponseAddGroupMessage.class, false);
        b(103104, ResponseDismissGroupMessage.class, false);
        b(208001, ResponseOfficialBarInfoMessage.class, false);
        b(208002, ResponseHistoryMessage.class, false);
        b(104001, ResponseSendPVTJMessage.class, false);
        b(103007, ResponseSearchGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        b(303006, ResponseOfficialBarMenuMessage.class, false);
        b(208003, ResponseSendOfficialBarMenuMessage.class, false);
        return true;
    }

    private static com.baidu.tbadk.task.b b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        return e.b(i, cls, z);
    }

    private static boolean QP() {
        b(2001106, p.class);
        b(2001211, r.class);
        b(2001212, q.class);
        b(2001213, s.class);
        b(2001148, j.class);
        b(2001151, o.class);
        b(2001154, k.class);
        b(2001155, l.class);
        b(2001156, m.class);
        b(2001181, n.class);
        return true;
    }

    private static com.baidu.tbadk.task.a b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        return e.b(i, cls);
    }

    private static boolean QQ() {
        MessageManager.getInstance().addResponsedMessageRule(new by());
        MessageManager.getInstance().addResponsedMessageRule(new ca());
        return true;
    }
}
