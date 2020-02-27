package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.x;
/* loaded from: classes9.dex */
public class b implements CustomMessageTask.CustomRunnable<bj>, x {
    private com.baidu.tieba.frs.d.b gGh;
    private int gwn = 3;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.gGh = null;
        this.mTbPageTag = null;
        this.gGh = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bj> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bj)) {
            bj data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                as(data);
                com.baidu.tieba.frs.d.c.bJH().a(this.gGh, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.gGh, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                as(data);
                com.baidu.tieba.frs.d.c.bJH().a(this.gGh, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.gGh, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                as(data);
                com.baidu.tieba.frs.d.c.bJH().a(this.gGh, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.gGh, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                at(data);
                com.baidu.tieba.frs.d.c.bJH().a(this.gGh, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.gGh, this.mTbPageTag);
            }
        }
        return null;
    }

    private void as(bj bjVar) {
        if (bjVar != null && bjVar.aCm() != null && bjVar.aCF() != null) {
            long j = 0;
            if (bjVar.aCF().user_info != null) {
                j = bjVar.aCF().user_info.ala_id;
            }
            TiebaStatic.log(new an("c13614").cy("uid", bjVar.aCm().getUserId()).s("fid", bjVar.getFid()).cy(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag).X("obj_type", bjVar.aCF().isChushou ? 2 : 1).cy("tid", bjVar.getTid()).s("liveid", bjVar.aCF().live_id).s("star_id", j).cy("extra", bjVar.mRecomExtra));
        }
    }

    private void at(bj bjVar) {
        if (bjVar != null && bjVar.aCm() != null && bjVar.aCF() != null) {
            long j = 0;
            if (bjVar.aCF().user_info != null) {
                j = bjVar.aCF().user_info.ala_id;
            }
            an anVar = new an("c13615");
            anVar.cy("uid", bjVar.aCm().getUserId());
            anVar.s("fid", bjVar.getFid());
            anVar.cy(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag);
            anVar.X("obj_type", bjVar.aCF().isChushou ? 2 : 1);
            anVar.cy("tid", bjVar.getTid());
            anVar.s("liveid", bjVar.aCF().live_id);
            anVar.s("star_id", j);
            anVar.cy("extra", bjVar.mRecomExtra);
            r.bve().d(anVar);
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwn = i;
    }
}
