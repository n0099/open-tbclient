package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.z;
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable<bh>, z {
    private int fCU = 3;
    private com.baidu.tieba.frs.d.b fMt;
    private BdUniqueId mPageId;

    public b(com.baidu.tieba.frs.d.b bVar, BdUniqueId bdUniqueId) {
        this.fMt = null;
        this.fMt = bVar;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bh> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bh)) {
            bh data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.d.c.brS().a(this.fMt, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.fMt);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.d.c.brS().a(this.fMt, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.fMt);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.d.c.brS().a(this.fMt, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.fMt);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.d.c.brS().a(this.fMt, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.fMt);
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nD(int i) {
        this.fCU = i;
    }
}
