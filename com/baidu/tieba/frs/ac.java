package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.r> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.atomData.r> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            if (TbadkApplication.m252getInst().isFrsImageForum(customMessage.getData().getIntent().getStringExtra("name"))) {
                customMessage.getData().getIntent().putExtra("add_search", 0);
                customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), FrsImageActivity.class);
            } else {
                customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), FrsActivity.class);
            }
            customMessage.getData().startActivity();
        }
        return null;
    }
}
