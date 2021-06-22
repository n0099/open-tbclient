package com.baidu.tieba.homepage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.n0.v0.b;
/* loaded from: classes4.dex */
public class HomePageStatic {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f16264a = false;

    static {
        a();
    }

    public static void a() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_POST, TbConfig.SERVER_ADDRESS + TbConfig.GET_MY_POST + "?cmd=303111");
        tbHttpMessageTask.setResponsedClass(GetMyPostHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        b bVar = new b(303111);
        bVar.setResponsedClass(GetMyPostSocketResponseMessage.class);
        bVar.g(true);
        bVar.h(false);
        bVar.f(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
    }
}
