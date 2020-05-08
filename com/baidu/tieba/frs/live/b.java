package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.x;
/* loaded from: classes9.dex */
public class b implements CustomMessageTask.CustomRunnable<bj>, x {
    private int hgL = 3;
    private com.baidu.tieba.frs.d.b hqS;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.hqS = null;
        this.mTbPageTag = null;
        this.hqS = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bj> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bj)) {
            bj data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                au(data);
                com.baidu.tieba.frs.d.c.bUs().a(this.hqS, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hqS, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                au(data);
                com.baidu.tieba.frs.d.c.bUs().a(this.hqS, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.hqS, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                au(data);
                com.baidu.tieba.frs.d.c.bUs().a(this.hqS, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hqS, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                av(data);
                com.baidu.tieba.frs.d.c.bUs().a(this.hqS, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.hqS, this.mTbPageTag);
            }
        }
        return null;
    }

    private void au(bj bjVar) {
        if (bjVar != null && bjVar.aKC() != null && bjVar.aKV() != null) {
            long j = 0;
            if (bjVar.aKV().user_info != null) {
                j = bjVar.aKV().user_info.ala_id;
            }
            TiebaStatic.log(new an("c13615").cI("uid", bjVar.aKC().getUserId()).t("fid", bjVar.getFid()).cI(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag).af("obj_type", bjVar.aKV().isChushou ? 2 : 1).cI("tid", bjVar.getTid()).t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bjVar.aKV().live_id).t("star_id", j).cI("extra", bjVar.mRecomExtra));
        }
    }

    private void av(bj bjVar) {
        if (bjVar != null && bjVar.aKC() != null && bjVar.aKV() != null) {
            long j = 0;
            if (bjVar.aKV().user_info != null) {
                j = bjVar.aKV().user_info.ala_id;
            }
            an anVar = new an("c13614");
            anVar.cI("uid", bjVar.aKC().getUserId());
            anVar.t("fid", bjVar.getFid());
            anVar.cI(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag);
            anVar.af("obj_type", bjVar.aKV().isChushou ? 2 : 1);
            anVar.cI("tid", bjVar.getTid());
            anVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bjVar.aKV().live_id);
            anVar.t("star_id", j);
            anVar.cI("extra", bjVar.mRecomExtra);
            r.bEW().e(anVar);
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgL = i;
    }
}
