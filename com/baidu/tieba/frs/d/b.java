package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class b implements CustomMessageTask.CustomRunnable<bj> {
    private com.baidu.tieba.frs.f.a cCQ;

    public b(com.baidu.tieba.frs.f.a aVar) {
        this.cCQ = null;
        this.cCQ = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bj> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bj)) {
            bj data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.f.b.alj().a(this.cCQ, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.f.b.alj().a(this.cCQ, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.f.b.alj().a(this.cCQ, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.f.b.alj().a(this.cCQ, data);
            }
        }
        return null;
    }
}
