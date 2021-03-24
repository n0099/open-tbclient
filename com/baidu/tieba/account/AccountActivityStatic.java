package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes4.dex */
public class AccountActivityStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(AccountActivity.class);
            }
            return null;
        }
    }

    static {
        a();
        b();
    }

    public static void a() {
        TbadkCoreApplication.getInst().RegisterIntent(AccountRestoreActivityConfig.class, AccountRestoreActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NotLoginGuideActivityConfig.class, NotLoginGuideActivity.class);
    }

    public static void b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015006, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
