package com.baidu.tieba.homepage.gamevideo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoHttpResMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoSocketResMessage;
import d.b.h0.v0.b;
import d.b.i0.c3.d0.a;
/* loaded from: classes4.dex */
public class GameVideoStatic {
    static {
        a();
    }

    public static void a() {
        b bVar = new b(309646);
        bVar.setResponsedClass(GameVideoSocketResMessage.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_VIDEO, a.a(TbConfig.URL_GAME_VIDEO, 309646));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GameVideoHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
