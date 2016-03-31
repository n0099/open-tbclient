package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GetOnLineInfoStatic {
    private static boolean aAl = true;
    private static Runnable mRunnable = new a();

    static {
        Gg();
        Gh();
        Gi();
        Gj();
    }

    private static void Gg() {
        MessageManager.getInstance().registerListener(new b(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
    }

    private static void Gh() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(205005);
        bVar.setResponsedClass(GetOnLineInfoSocketResMessage.class);
        bVar.i(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
    }

    private static void Gi() {
        c cVar = new c(205005);
        cVar.setSelfListener(true);
        MessageManager.getInstance().registerListener(cVar);
    }

    private static void Gj() {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }
}
