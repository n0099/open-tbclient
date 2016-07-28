package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GetOnLineInfoStatic {
    private static boolean axS = true;
    private static Runnable mRunnable = new a();

    static {
        Eh();
        Ei();
        Ej();
        Ek();
    }

    private static void Eh() {
        MessageManager.getInstance().registerListener(new b(1001));
    }

    private static void Ei() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(205005);
        bVar.setResponsedClass(GetOnLineInfoSocketResMessage.class);
        bVar.k(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
    }

    private static void Ej() {
        c cVar = new c(205005);
        cVar.setSelfListener(true);
        MessageManager.getInstance().registerListener(cVar);
    }

    private static void Ek() {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }
}
