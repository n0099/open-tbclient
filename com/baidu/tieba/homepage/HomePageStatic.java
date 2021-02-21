package com.baidu.tieba.homepage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
/* loaded from: classes.dex */
public class HomePageStatic {
    public static boolean jZe = false;

    static {
        cOK();
    }

    public static void cOK() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003010, TbConfig.SERVER_ADDRESS + TbConfig.GET_MY_POST + "?cmd=" + CmdConfigSocket.CMD_GET_MY_POST);
        tbHttpMessageTask.setResponsedClass(GetMyPostHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        b bVar = new b(CmdConfigSocket.CMD_GET_MY_POST);
        bVar.setResponsedClass(GetMyPostSocketResponseMessage.class);
        bVar.setNeedAck(true);
        bVar.setNeedCompress(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
    }
}
