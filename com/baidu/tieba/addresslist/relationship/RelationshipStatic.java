package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RelationshipStatic {
    static {
        a(304001, ResponseGetAddressListMessage.class, false);
        a(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST, b.class);
        a(CmdConfigCustom.CMD_QUERY_CONTACT_LIST, c.class);
        a(CmdConfigCustom.CMD_INSERT_CONTACT, d.class);
        a(CmdConfigCustom.CMD_DELETE_CONTACT, d.class);
        MessageManager.getInstance().registerListener(new i(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
        MessageManager.getInstance().registerListener(new j(304001));
        MessageManager.getInstance().registerListener(new k(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL));
        MessageManager.getInstance().registerListener(new l(CmdConfigCustom.CLOSE_ALL_ACTIVITY));
    }

    private static void a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tieba.im.e.b(i, cls, z);
    }

    private static void a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        com.baidu.tieba.im.e.b(i, cls);
    }
}
