package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ad implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ ac cVV;
    private final /* synthetic */ ImMessageCenterPojo cVW;
    private final /* synthetic */ ImMessageCenterPojo cVc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.cVV = acVar;
        this.cVc = imMessageCenterPojo;
        this.cVW = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.anz().a(this.cVc, 2);
        if (this.cVW != null) {
            com.baidu.tieba.im.db.i.anz().a(this.cVW, 2);
            return null;
        }
        return null;
    }
}
