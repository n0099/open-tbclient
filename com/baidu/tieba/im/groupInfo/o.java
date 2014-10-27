package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements CustomMessageTask.CustomRunnable<GroupInfoActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<GroupInfoActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), GroupInfoActivity.class);
            int intExtra = customMessage.getData().getIntent().getIntExtra(GroupInfoActivityConfig.REQUEST_CODE, -1);
            if (intExtra != -1) {
                customMessage.getData().startActivityForResult(intExtra);
            } else {
                customMessage.getData().startActivity();
            }
        }
        return null;
    }
}
