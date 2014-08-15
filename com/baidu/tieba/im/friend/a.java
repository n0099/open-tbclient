package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ab;
/* loaded from: classes.dex */
class a implements CustomMessageTask.CustomRunnable<ab> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ab> run(CustomMessage<ab> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), IMBlackListActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
