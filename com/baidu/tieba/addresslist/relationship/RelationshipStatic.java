package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
public class RelationshipStatic {
    static {
        a(304001, ResponseGetAddressListMessage.class, false);
        a(2001182, c.class);
        a(2001188, d.class);
        a(2001183, e.class);
        a(2001184, e.class);
        MessageManager.getInstance().registerListener(new j(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
        MessageManager.getInstance().registerListener(new k(304001));
        MessageManager.getInstance().registerListener(new l(2001178));
    }

    private static void a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tieba.im.e.b(i, cls, z);
    }

    private static void a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        com.baidu.tieba.im.e.b(i, cls);
    }
}
