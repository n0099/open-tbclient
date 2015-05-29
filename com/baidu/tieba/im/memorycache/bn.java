package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo bmQ;
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, ImMessageCenterPojo imMessageCenterPojo) {
        this.this$0 = imMemoryCacheRegisterStatic;
        this.bmQ = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.db.k.Rv().a(this.bmQ, 2);
        }
        return null;
    }
}
