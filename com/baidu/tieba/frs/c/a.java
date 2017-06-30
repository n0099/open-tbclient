package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.frs.d.b;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<bm> {
    private com.baidu.tieba.frs.d.a cmh;

    public a(com.baidu.tieba.frs.d.a aVar) {
        this.cmh = null;
        this.cmh = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bm> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bm)) {
            bm data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                b.aho().a(this.cmh, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                b.aho().a(this.cmh, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                b.aho().a(this.cmh, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                b.aho().a(this.cmh, data);
            }
        }
        return null;
    }
}
