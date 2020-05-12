package com.baidu.tieba.homepage.gamevideo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoHttpResMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoSocketResMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes9.dex */
public class GameVideoStatic {
    static {
        bYM();
    }

    private static void bYM() {
        b bVar = new b(309646);
        bVar.setResponsedClass(GameVideoSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_VIDEO, a.bE(TbConfig.URL_GAME_VIDEO, 309646));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GameVideoHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
