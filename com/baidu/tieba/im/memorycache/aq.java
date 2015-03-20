package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class aq implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ao bkf;
    private final /* synthetic */ ImMessageCenterPojo bkg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bkf = aoVar;
        this.bkg = imMessageCenterPojo;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.k.PT().a(this.bkg);
        return null;
    }
}
