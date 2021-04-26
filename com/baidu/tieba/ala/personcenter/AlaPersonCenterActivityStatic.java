package com.baidu.tieba.ala.personcenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaPrivilegeListActivityConfig;
import com.baidu.ala.message.GlobalPushSwitchResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.privilege.AlaPersonCenterPrivilegeActivity;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaGetEnterEffectResponsedMessage;
import d.a.j0.q0.j0;
/* loaded from: classes4.dex */
public class AlaPersonCenterActivityStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof j0) {
                j0 j0Var = (j0) data;
                d.a.j0.t.j.a aVar = new d.a.j0.t.j.a();
                aVar.c(j0Var.d());
                aVar.d(j0Var.e());
                aVar.b(j0Var.c());
                aVar.e(j0Var.f());
                aVar.a(j0Var);
            }
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaPersonCenterActivityConfig.class, AlaPersonCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaPrivilegeListActivityConfig.class, AlaPersonCenterPrivilegeActivity.class);
        b();
        a();
        MessageManager.getInstance().registerListener(new a(2001616));
    }

    public static void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_ENTER_EFFECT);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaGetEnterEffectResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static final void b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_GLOBAL_PUSH_SWITCH, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_GLOBAL_PUSH_SWITCH_URL);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GlobalPushSwitchResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
