package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.aa;
/* loaded from: classes.dex */
class l implements CustomMessageTask.CustomRunnable<aa> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<aa> run(CustomMessage<aa> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.d.a.a().a(customMessage.getData().getIntent().getIntArrayExtra("timeouts"));
        }
        return null;
    }
}
