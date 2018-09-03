package com.baidu.tieba.frs.live;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class b implements CustomMessageTask.CustomRunnable<bb>, ab {
    private com.baidu.tieba.frs.e.a dCZ;
    private int dtU = 3;

    public b(com.baidu.tieba.frs.e.a aVar) {
        this.dCZ = null;
        this.dCZ = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bb> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bb)) {
            bb data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.e.b.aAa().a(this.dCZ, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.e.b.aAa().a(this.dCZ, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.e.b.aAa().a(this.dCZ, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.e.b.aAa().a(this.dCZ, data);
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.dtU = i;
    }
}
