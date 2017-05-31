package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.frs.d.b;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<bl> {
    private com.baidu.tieba.frs.d.a cdU;

    public a(com.baidu.tieba.frs.d.a aVar) {
        this.cdU = null;
        this.cdU = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bl> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bl)) {
            bl data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                b.adw().a(this.cdU, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                b.adw().a(this.cdU, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                b.adw().a(this.cdU, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                b.adw().a(this.cdU, data);
            }
        }
        return null;
    }
}
