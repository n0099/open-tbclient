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
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.y;
/* loaded from: classes22.dex */
public class b implements CustomMessageTask.CustomRunnable<bw>, y {
    private com.baidu.tieba.frs.d.b iKe;
    private int iKf;
    private int iyR = 3;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.iKe = null;
        this.mTbPageTag = null;
        this.iKe = bVar;
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
                com.baidu.tieba.frs.d.c.czh().a(this.iKe, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.iKe, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                at(data);
                com.baidu.tieba.frs.d.c.czh().a(this.iKe, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.iKe, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                at(data);
                com.baidu.tieba.frs.d.c.czh().a(this.iKe, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.iKe, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                au(data);
                com.baidu.tieba.frs.d.c.czh().a(this.iKe, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.iKe, this.mTbPageTag);
            }
        }
        return null;
    }

    private void at(bw bwVar) {
        if (bwVar != null && bwVar.bih() != null && bwVar.biB() != null) {
            long j = 0;
            if (bwVar.biB().user_info != null) {
                j = bwVar.biB().user_info.ala_id;
            }
            aq aqVar = new aq("c13615");
            aqVar.dK("uid", bwVar.bih().getUserId());
            aqVar.u("fid", bwVar.getFid());
            aqVar.dK("ab_tag", bwVar.mRecomAbTag);
            aqVar.aj("obj_type", bwVar.biB().isChushou ? 2 : 1);
            aqVar.dK("tid", bwVar.getTid());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.biB().live_id);
            aqVar.u("star_id", j);
            aqVar.dK("extra", bwVar.mRecomExtra);
            aqVar.dK("source_from", bwVar.mRecomSource);
            if (this.iKf == 14) {
                aqVar.aj("obj_locate", 1);
            } else if (this.iKf == 13) {
                aqVar.aj("obj_locate", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void au(bw bwVar) {
        if (bwVar != null && bwVar.bih() != null && bwVar.biB() != null) {
            long j = 0;
            if (bwVar.biB().user_info != null) {
                j = bwVar.biB().user_info.ala_id;
            }
            aq aqVar = new aq("c13614");
            aqVar.dK("uid", bwVar.bih().getUserId());
            aqVar.u("fid", bwVar.getFid());
            aqVar.dK("ab_tag", bwVar.mRecomAbTag);
            aqVar.aj("obj_type", bwVar.biB().isChushou ? 2 : 1);
            aqVar.dK("tid", bwVar.getTid());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.biB().live_id);
            aqVar.u("star_id", j);
            aqVar.dK("extra", bwVar.mRecomExtra);
            aqVar.dK("source_from", bwVar.mRecomSource);
            if (this.iKf == 14) {
                aqVar.aj("obj_locate", 1);
            } else if (this.iKf == 13) {
                aqVar.aj("obj_locate", 2);
            }
            s.ciJ().e(aqVar);
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.iyR = i;
    }

    public void zq(int i) {
        this.iKf = i;
    }
}
