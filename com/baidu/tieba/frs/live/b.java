package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.x;
/* loaded from: classes6.dex */
public class b implements CustomMessageTask.CustomRunnable<bj>, x {
    private com.baidu.tieba.frs.d.b gAY;
    private int grd = 3;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.gAY = null;
        this.mTbPageTag = null;
        this.gAY = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bj> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bj)) {
            bj data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                com.baidu.tieba.frs.d.c.bHd().a(this.gAY, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.gAY, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                com.baidu.tieba.frs.d.c.bHd().a(this.gAY, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.gAY, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                com.baidu.tieba.frs.d.c.bHd().a(this.gAY, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.gAY, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                com.baidu.tieba.frs.d.c.bHd().a(this.gAY, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.gAY, this.mTbPageTag);
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
        this.grd = i;
    }
}
