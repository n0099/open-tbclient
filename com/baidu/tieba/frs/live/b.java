package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.card.ab;
/* loaded from: classes6.dex */
public class b implements CustomMessageTask.CustomRunnable<bb>, ab {
    private int dTF = 3;
    private com.baidu.tieba.frs.e.b ecT;
    private BdUniqueId mPageId;

    public b(com.baidu.tieba.frs.e.b bVar, BdUniqueId bdUniqueId) {
        this.ecT = null;
        this.ecT = bVar;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bb> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bb)) {
            bb data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.e.c.aHW().a(this.ecT, data, 1);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.e.c.aHW().a(this.ecT, data, 2);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.e.c.aHW().a(this.ecT, data, 4);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.e.c.aHW().a(this.ecT, data);
                com.baidu.tieba.frs.e.a.a(data, this.mPageId, this.ecT);
            }
            if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.e.a.a(data, 2, this.mPageId, this.ecT);
            } else {
                com.baidu.tieba.frs.e.a.a(data, 1, this.mPageId, this.ecT);
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTF = i;
    }
}
