package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
public class GetOnLineInfoStatic {
    static {
        CS();
        CT();
        CU();
    }

    private static void CS() {
        MessageManager.getInstance().registerListener(new a(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
    }

    private static void CT() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(205005);
        bVar.setResponsedClass(GetOnLineInfoSocketResMessage.class);
        bVar.j(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
    }

    private static void CU() {
        c cVar = new c(205005);
        cVar.setSelfListener(true);
        MessageManager.getInstance().registerListener(cVar);
    }
}
