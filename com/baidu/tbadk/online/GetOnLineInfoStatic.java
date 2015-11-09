package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class GetOnLineInfoStatic {
    private static Runnable mRunnable = new a();

    static {
        Di();
        Dj();
        Dk();
        Dl();
    }

    private static void Di() {
        MessageManager.getInstance().registerListener(new b(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
    }

    private static void Dj() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(205005);
        bVar.setResponsedClass(GetOnLineInfoSocketResMessage.class);
        bVar.j(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
    }

    private static void Dk() {
        c cVar = new c(205005);
        cVar.setSelfListener(true);
        MessageManager.getInstance().registerListener(cVar);
    }

    private static void Dl() {
        MessageManager.getInstance().registerListener(new d(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }
}
