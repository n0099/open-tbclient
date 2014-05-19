package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.t> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.atomData.t> run(CustomMessage<com.baidu.tbadk.core.atomData.t> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), IMBlackListActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
