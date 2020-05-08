package com.baidu.tieba.frs.ad;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes9.dex */
public class FrsADStatic {
    static {
        bQP();
    }

    private static void bQP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK, TbConfig.SERVER_ADDRESS + TbConfig.URL_FRS_BUSINESS_PROMOT_CLICK);
        tbHttpMessageTask.setIsNeedLogin(false);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
