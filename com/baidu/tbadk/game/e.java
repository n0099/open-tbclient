package com.baidu.tbadk.game;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class e {
    private static e Zi;

    private e() {
    }

    public static e vy() {
        if (Zi == null) {
            Zi = new e();
        }
        return Zi;
    }

    public void s(String str, int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.UPDATE_PLAYER_NUM_CMD);
        httpMessage.addParam("gameId", str);
        httpMessage.addParam("type", Integer.valueOf(i));
        MessageManager.getInstance().sendMessage(httpMessage, new TbHttpMessageTask(CmdConfigHttp.UPDATE_PLAYER_NUM_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UPDATE_PLAYER_NUM));
    }
}
