package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class b implements CustomMessageTask.CustomRunnable<bl> {
    private com.baidu.tieba.frs.f.a csX;

    public b(com.baidu.tieba.frs.f.a aVar) {
        this.csX = null;
        this.csX = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bl> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bl)) {
            bl data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.f.b.aiM().a(this.csX, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.f.b.aiM().a(this.csX, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.f.b.aiM().a(this.csX, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.f.b.aiM().a(this.csX, data);
            }
        }
        return null;
    }
}
