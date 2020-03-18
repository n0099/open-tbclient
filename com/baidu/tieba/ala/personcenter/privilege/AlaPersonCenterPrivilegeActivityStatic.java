package com.baidu.tieba.ala.personcenter.privilege;

import com.baidu.adp.framework.MessageManager;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaPrivilegeListActivityConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaGetEnterEffectResponsedMessage;
/* loaded from: classes3.dex */
public class AlaPersonCenterPrivilegeActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaPrivilegeListActivityConfig.class, AlaPersonCenterPrivilegeActivity.class);
        bsl();
        bsp();
    }

    private static void bsl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_ENTER_EFFECT);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaGetEnterEffectResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bsp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_BUY_TDOU_PRIVILEGE);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTDouBuyPrivilegeResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
