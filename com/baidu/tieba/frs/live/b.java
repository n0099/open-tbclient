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
    private com.baidu.tieba.frs.d.b gHt;
    private int gxk = 3;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.gHt = null;
        this.mTbPageTag = null;
        this.gHt = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bj> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bj)) {
            bj data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                at(data);
                com.baidu.tieba.frs.d.c.bJX().a(this.gHt, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.gHt, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                at(data);
                com.baidu.tieba.frs.d.c.bJX().a(this.gHt, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.gHt, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                at(data);
                com.baidu.tieba.frs.d.c.bJX().a(this.gHt, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.gHt, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                au(data);
                com.baidu.tieba.frs.d.c.bJX().a(this.gHt, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.gHt, this.mTbPageTag);
            }
        }
        return null;
    }

    private void at(bj bjVar) {
        if (bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
            long j = 0;
            if (bjVar.aCK().user_info != null) {
                j = bjVar.aCK().user_info.ala_id;
            }
            TiebaStatic.log(new an("c13615").cx("uid", bjVar.aCr().getUserId()).s("fid", bjVar.getFid()).cx(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag).X("obj_type", bjVar.aCK().isChushou ? 2 : 1).cx("tid", bjVar.getTid()).s("liveid", bjVar.aCK().live_id).s("star_id", j).cx("extra", bjVar.mRecomExtra));
        }
    }

    private void au(bj bjVar) {
        if (bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
            long j = 0;
            if (bjVar.aCK().user_info != null) {
                j = bjVar.aCK().user_info.ala_id;
            }
            an anVar = new an("c13614");
            anVar.cx("uid", bjVar.aCr().getUserId());
            anVar.s("fid", bjVar.getFid());
            anVar.cx(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag);
            anVar.X("obj_type", bjVar.aCK().isChushou ? 2 : 1);
            anVar.cx("tid", bjVar.getTid());
            anVar.s("liveid", bjVar.aCK().live_id);
            anVar.s("star_id", j);
            anVar.cx("extra", bjVar.mRecomExtra);
            r.bvm().e(anVar);
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
        this.gxk = i;
    }
}
