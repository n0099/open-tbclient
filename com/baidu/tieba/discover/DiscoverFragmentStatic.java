package com.baidu.tieba.discover;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes2.dex */
public class DiscoverFragmentStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921010, new CustomMessageTask.CustomRunnable<BaseFragment>() { // from class: com.baidu.tieba.discover.DiscoverFragmentStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<BaseFragment> run(CustomMessage<BaseFragment> customMessage) {
                return new CustomResponsedMessage<>(2921010, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
