package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GetOnLineInfoStatic {
    private static boolean awo = true;
    private static Runnable mRunnable = new a();

    static {
        DZ();
        Ea();
        Eb();
        Ec();
    }

    private static void DZ() {
        MessageManager.getInstance().registerListener(new b(1001));
    }

    private static void Ea() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(205005);
        bVar.setResponsedClass(GetOnLineInfoSocketResMessage.class);
        bVar.i(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
    }

    private static void Eb() {
        c cVar = new c(205005);
        cVar.setSelfListener(true);
        MessageManager.getInstance().registerListener(cVar);
    }

    private static void Ec() {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }
}
