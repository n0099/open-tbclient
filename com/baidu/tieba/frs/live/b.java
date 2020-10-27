package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.z;
/* loaded from: classes22.dex */
public class b implements CustomMessageTask.CustomRunnable<bw>, z {
    private int iLn = 3;
    private com.baidu.tieba.frs.d.b iWA;
    private int iWB;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.iWA = null;
        this.mTbPageTag = null;
        this.iWA = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bw> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bw)) {
            bw data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                at(data);
                com.baidu.tieba.frs.d.c.cCo().a(this.iWA, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.iWA, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                at(data);
                com.baidu.tieba.frs.d.c.cCo().a(this.iWA, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.iWA, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                at(data);
                com.baidu.tieba.frs.d.c.cCo().a(this.iWA, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.iWA, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                au(data);
                com.baidu.tieba.frs.d.c.cCo().a(this.iWA, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.iWA, this.mTbPageTag);
            }
        }
        return null;
    }

    private void at(bw bwVar) {
        if (bwVar != null && bwVar.bka() != null && bwVar.bku() != null) {
            long j = 0;
            if (bwVar.bku().user_info != null) {
                j = bwVar.bku().user_info.ala_id;
            }
            aq aqVar = new aq("c13615");
            aqVar.dR("uid", bwVar.bka().getUserId());
            aqVar.w("fid", bwVar.getFid());
            aqVar.dR("ab_tag", bwVar.mRecomAbTag);
            aqVar.aj("obj_type", bwVar.bku().isChushou ? 2 : 1);
            aqVar.dR("tid", bwVar.getTid());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.bku().live_id);
            aqVar.w("star_id", j);
            aqVar.dR("extra", bwVar.mRecomExtra);
            aqVar.dR("source_from", bwVar.mRecomSource);
            if (this.iWB == 14) {
                aqVar.aj("obj_locate", 1);
            } else if (this.iWB == 13) {
                aqVar.aj("obj_locate", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void au(bw bwVar) {
        if (bwVar != null && bwVar.bka() != null && bwVar.bku() != null) {
            long j = 0;
            if (bwVar.bku().user_info != null) {
                j = bwVar.bku().user_info.ala_id;
            }
            aq aqVar = new aq("c13614");
            aqVar.dR("uid", bwVar.bka().getUserId());
            aqVar.w("fid", bwVar.getFid());
            aqVar.dR("ab_tag", bwVar.mRecomAbTag);
            aqVar.aj("obj_type", bwVar.bku().isChushou ? 2 : 1);
            aqVar.dR("tid", bwVar.getTid());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.bku().live_id);
            aqVar.w("star_id", j);
            aqVar.dR("extra", bwVar.mRecomExtra);
            aqVar.dR("source_from", bwVar.mRecomSource);
            if (this.iWB == 14) {
                aqVar.aj("obj_locate", 1);
            } else if (this.iWB == 13) {
                aqVar.aj("obj_locate", 2);
            }
            t.clQ().e(aqVar);
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
        this.iLn = i;
    }

    public void zJ(int i) {
        this.iWB = i;
    }
}
