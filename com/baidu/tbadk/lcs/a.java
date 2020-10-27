package com.baidu.tbadk.lcs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class a {
    private static boolean fmJ;

    static {
        fmJ = false;
        fmJ = b.bnH().getInt("key_lcs_log_switch", 0) == 1;
        if (fmJ) {
            registerTask();
        }
    }

    private static void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_LCS_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.LCS_STATISTICS_URL);
        tbHttpMessageTask.setResponsedClass(LCSStatisticsResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void d(int i, int i2, int i3, int i4, int i5) {
        e(i, i2, i3, i4, i5, 0);
    }

    public static void e(int i, int i2, int i3, int i4, int i5, int i6) {
        if (fmJ) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_LCS_STATISTICS);
            httpMessage.addParam("cmd", i);
            httpMessage.addParam("lcs_status", i2);
            httpMessage.addParam("online_status", i3);
            httpMessage.addParam("status_change_name", i4);
            httpMessage.addParam("status_change_trigger", i5);
            httpMessage.addParam("lcs_vailable", i6);
            MessageManager.getInstance().sendMessageFromBackground(httpMessage);
        }
    }
}
