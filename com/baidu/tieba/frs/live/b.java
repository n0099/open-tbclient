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
    private int hgF = 3;
    private com.baidu.tieba.frs.d.b hqM;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.hqM = null;
        this.mTbPageTag = null;
        this.hqM = bVar;
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
                com.baidu.tieba.frs.d.c.bUu().a(this.hqM, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hqM, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                au(data);
                com.baidu.tieba.frs.d.c.bUu().a(this.hqM, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.hqM, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                au(data);
                com.baidu.tieba.frs.d.c.bUu().a(this.hqM, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hqM, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                av(data);
                com.baidu.tieba.frs.d.c.bUu().a(this.hqM, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.hqM, this.mTbPageTag);
            }
        }
        return null;
    }

    private void au(bj bjVar) {
        if (bjVar != null && bjVar.aKE() != null && bjVar.aKX() != null) {
            long j = 0;
            if (bjVar.aKX().user_info != null) {
                j = bjVar.aKX().user_info.ala_id;
            }
            TiebaStatic.log(new an("c13615").cI("uid", bjVar.aKE().getUserId()).t("fid", bjVar.getFid()).cI(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag).af("obj_type", bjVar.aKX().isChushou ? 2 : 1).cI("tid", bjVar.getTid()).t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bjVar.aKX().live_id).t("star_id", j).cI("extra", bjVar.mRecomExtra));
        }
    }

    private void av(bj bjVar) {
        if (bjVar != null && bjVar.aKE() != null && bjVar.aKX() != null) {
            long j = 0;
            if (bjVar.aKX().user_info != null) {
                j = bjVar.aKX().user_info.ala_id;
            }
            an anVar = new an("c13614");
            anVar.cI("uid", bjVar.aKE().getUserId());
            anVar.t("fid", bjVar.getFid());
            anVar.cI(TiebaInitialize.Params.AB_TAG, bjVar.mRecomAbTag);
            anVar.af("obj_type", bjVar.aKX().isChushou ? 2 : 1);
            anVar.cI("tid", bjVar.getTid());
            anVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bjVar.aKX().live_id);
            anVar.t("star_id", j);
            anVar.cI("extra", bjVar.mRecomExtra);
            r.bEY().e(anVar);
        }
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgF = i;
    }
}
