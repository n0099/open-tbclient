package com.baidu.tbadk.game;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class e {
    private static e avt;

    private e() {
    }

    public static e CC() {
        if (avt == null) {
            avt = new e();
        }
        return avt;
    }

    public void w(String str, int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.UPDATE_PLAYER_NUM_CMD);
        httpMessage.addParam("gameId", str);
        httpMessage.addParam("type", Integer.valueOf(i));
        MessageManager.getInstance().sendMessage(httpMessage, new TbHttpMessageTask(CmdConfigHttp.UPDATE_PLAYER_NUM_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UPDATE_PLAYER_NUM));
    }
}
