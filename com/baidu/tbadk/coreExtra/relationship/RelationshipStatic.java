package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class RelationshipStatic {
    static {
        a(304001, ResponseGetAddressListMessage.class, false);
        a(2001182, d.class);
        a(2001188, e.class);
        a(2001183, g.class);
        a(2001184, g.class);
        MessageManager.getInstance().registerListener(new l(1001));
        MessageManager.getInstance().registerListener(new m(304001));
        MessageManager.getInstance().registerListener(new n(2001178));
    }

    private static void a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tieba.im.e.b(i, cls, z);
    }

    private static void a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        com.baidu.tieba.im.e.b(i, cls);
    }
}
