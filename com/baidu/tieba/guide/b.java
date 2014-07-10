package com.baidu.tieba.guide;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.as;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<as> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<as> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), NewUserGuideActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
