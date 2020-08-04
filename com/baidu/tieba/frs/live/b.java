package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.y;
/* loaded from: classes16.dex */
public class b implements CustomMessageTask.CustomRunnable<bv>, y {
    private int hOF = 3;
    private com.baidu.tieba.frs.d.b hZH;
    private int hZI;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.hZH = null;
        this.mTbPageTag = null;
        this.hZH = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bv> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bv)) {
            bv data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                as(data);
                com.baidu.tieba.frs.d.c.chQ().a(this.hZH, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hZH, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                as(data);
                com.baidu.tieba.frs.d.c.chQ().a(this.hZH, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.hZH, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                as(data);
                com.baidu.tieba.frs.d.c.chQ().a(this.hZH, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hZH, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                at(data);
                com.baidu.tieba.frs.d.c.chQ().a(this.hZH, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.hZH, this.mTbPageTag);
            }
        }
        return null;
    }

    private void as(bv bvVar) {
        if (bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            long j = 0;
            if (bvVar.aWF().user_info != null) {
                j = bvVar.aWF().user_info.ala_id;
            }
            ap apVar = new ap("c13615");
            apVar.dn("uid", bvVar.aWl().getUserId());
            apVar.t("fid", bvVar.getFid());
            apVar.dn("ab_tag", bvVar.mRecomAbTag);
            apVar.ah("obj_type", bvVar.aWF().isChushou ? 2 : 1);
            apVar.dn("tid", bvVar.getTid());
            apVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bvVar.aWF().live_id);
            apVar.t("star_id", j);
            apVar.dn("extra", bvVar.mRecomExtra);
            apVar.dn("source_from", bvVar.mRecomSource);
            if (this.hZI == 14) {
                apVar.ah("obj_locate", 1);
            } else if (this.hZI == 13) {
                apVar.ah("obj_locate", 2);
            }
            TiebaStatic.log(apVar);
        }
    }

    private void at(bv bvVar) {
        if (bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            long j = 0;
            if (bvVar.aWF().user_info != null) {
                j = bvVar.aWF().user_info.ala_id;
            }
            ap apVar = new ap("c13614");
            apVar.dn("uid", bvVar.aWl().getUserId());
            apVar.t("fid", bvVar.getFid());
            apVar.dn("ab_tag", bvVar.mRecomAbTag);
            apVar.ah("obj_type", bvVar.aWF().isChushou ? 2 : 1);
            apVar.dn("tid", bvVar.getTid());
            apVar.t(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bvVar.aWF().live_id);
            apVar.t("star_id", j);
            apVar.dn("extra", bvVar.mRecomExtra);
            apVar.dn("source_from", bvVar.mRecomSource);
            if (this.hZI == 14) {
                apVar.ah("obj_locate", 1);
            } else if (this.hZI == 13) {
                apVar.ah("obj_locate", 2);
            }
            s.bRL().e(apVar);
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOF = i;
    }

    public void vS(int i) {
        this.hZI = i;
    }
}
