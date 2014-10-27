package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
/* loaded from: classes.dex */
public class GetOnLineInfoStatic {
    static {
        uo();
        up();
        uq();
    }

    private static void uo() {
        MessageManager.getInstance().registerListener(new a(1001));
    }

    private static void up() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(205005);
        bVar.setResponsedClass(GetOnLineInfoSocketResMessage.class);
        bVar.f(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
    }

    private static void uq() {
        c cVar = new c(205005);
        cVar.setSelfListener(true);
        MessageManager.getInstance().registerListener(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(long j) {
        long j2 = com.baidu.tbadk.core.sharedPref.b.lk().getLong("game_last_time", 0L);
        if (j2 == 0 || j > j2) {
            com.baidu.tbadk.core.sharedPref.b.lk().putLong("game_last_time", j);
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_is_show_tip", true);
            return true;
        }
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_is_show_tip", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ur() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, true));
    }
}
