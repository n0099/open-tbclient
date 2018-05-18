package com.baidu.tieba.frs.live;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes2.dex */
public class b implements CustomMessageTask.CustomRunnable<bd> {
    private com.baidu.tieba.frs.e.a dnL;

    public b(com.baidu.tieba.frs.e.a aVar) {
        this.dnL = null;
        this.dnL = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bd> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bd)) {
            bd data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.e.b.auG().a(this.dnL, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.e.b.auG().a(this.dnL, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.e.b.auG().a(this.dnL, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.e.b.auG().a(this.dnL, data);
            }
        }
        return null;
    }
}
