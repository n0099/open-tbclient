package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.IUpdatesModel;
import com.baidu.tieba.im.model.UpdatesModel;
/* loaded from: classes3.dex */
public class UpdatesStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001286, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001286, Integer.valueOf(f.C0146f.icon_new_trends));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001298, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001298, new a());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    /* loaded from: classes3.dex */
    static class a implements IUpdatesModel {
        a() {
        }

        @Override // com.baidu.tieba.im.model.IUpdatesModel
        public UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
            return UpdatesModel.convertToUpdatesItem(groupNewsPojo);
        }
    }
}
