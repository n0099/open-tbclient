package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class ad implements CustomMessageTask.CustomRunnable<String> {
    private final /* synthetic */ ImMessageCenterPojo cbq;
    final /* synthetic */ ac ccj;
    private final /* synthetic */ ImMessageCenterPojo cck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterPojo imMessageCenterPojo2) {
        this.ccj = acVar;
        this.cbq = imMessageCenterPojo;
        this.cck = imMessageCenterPojo2;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        com.baidu.tieba.im.db.i.abc().a(this.cbq, 2);
        if (this.cck != null) {
            com.baidu.tieba.im.db.i.abc().a(this.cck, 2);
            return null;
        }
        return null;
    }
}
