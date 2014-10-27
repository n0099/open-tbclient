package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import com.baidu.tieba.im.message.g;
/* loaded from: classes.dex */
public class OfficialBarTipModelStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003004, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.model.OfficialBarTipModelStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
                if (customMessage != null) {
                    String data = customMessage.getData();
                    if (!TextUtils.isEmpty(data)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyVisibilityMessage(new g(data, 4, false)));
                    }
                }
                return null;
            }
        });
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
