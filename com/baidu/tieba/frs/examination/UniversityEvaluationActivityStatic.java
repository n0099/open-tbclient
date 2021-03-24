package com.baidu.tieba.frs.examination;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes4.dex */
public class UniversityEvaluationActivityStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                int requestCode = customMessage.getData().getRequestCode();
                if (requestCode == 0) {
                    customMessage.getData().startActivity(UniversityEvaluationActivity.class);
                } else {
                    customMessage.getData().startActivityForResult(requestCode, UniversityEvaluationActivity.class);
                }
            }
            return null;
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921460, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
