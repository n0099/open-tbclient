package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.account.appeal.AppealActivity;
/* loaded from: classes.dex */
public class AccountActivityStatic {
    static {
        KG();
        DU();
    }

    private static void DU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_ACCOUNT, new k());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void KG() {
        AppealActivityConfig.isExistActivity = true;
        TbadkCoreApplication.m9getInst().RegisterIntent(AccountRestoreActivityConfig.class, AccountRestoreActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(NotLoginGuideActivityConfig.class, NotLoginGuideActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(AppealActivityConfig.class, AppealActivity.class);
    }
}
