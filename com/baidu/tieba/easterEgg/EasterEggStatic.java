package com.baidu.tieba.easterEgg;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class EasterEggStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TbadkCoreApplication.getInst().startService(new Intent(TbadkCoreApplication.getInst(), EasterEggH5Service.class));
        }
    }

    static {
        a();
        b();
    }

    public static void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_RN_SYNC, TbConfig.SERVER_ADDRESS + TbConfig.GET_RN_SYNC_ADDRESS);
        tbHttpMessageTask.setResponsedClass(RnSyncResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void b() {
        MessageManager.getInstance().registerListener(new a(2001371));
    }
}
