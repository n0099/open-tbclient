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
/* loaded from: classes16.dex */
public class b implements CustomMessageTask.CustomRunnable<bw>, y {
    private int icK = 3;
    private com.baidu.tieba.frs.d.b inP;
    private int inQ;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.inP = null;
        this.mTbPageTag = null;
        this.inP = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bw> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bw)) {
            bw data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                as(data);
                com.baidu.tieba.frs.d.c.csu().a(this.inP, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.inP, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                as(data);
                com.baidu.tieba.frs.d.c.csu().a(this.inP, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.inP, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                as(data);
                com.baidu.tieba.frs.d.c.csu().a(this.inP, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.inP, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                at(data);
                com.baidu.tieba.frs.d.c.csu().a(this.inP, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.inP, this.mTbPageTag);
            }
        }
        return null;
    }

    private void as(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            long j = 0;
            if (bwVar.beY().user_info != null) {
                j = bwVar.beY().user_info.ala_id;
            }
            aq aqVar = new aq("c13615");
            aqVar.dD("uid", bwVar.beE().getUserId());
            aqVar.u("fid", bwVar.getFid());
            aqVar.dD("ab_tag", bwVar.mRecomAbTag);
            aqVar.ai("obj_type", bwVar.beY().isChushou ? 2 : 1);
            aqVar.dD("tid", bwVar.getTid());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.beY().live_id);
            aqVar.u("star_id", j);
            aqVar.dD("extra", bwVar.mRecomExtra);
            aqVar.dD("source_from", bwVar.mRecomSource);
            if (this.inQ == 14) {
                aqVar.ai("obj_locate", 1);
            } else if (this.inQ == 13) {
                aqVar.ai("obj_locate", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void at(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            long j = 0;
            if (bwVar.beY().user_info != null) {
                j = bwVar.beY().user_info.ala_id;
            }
            aq aqVar = new aq("c13614");
            aqVar.dD("uid", bwVar.beE().getUserId());
            aqVar.u("fid", bwVar.getFid());
            aqVar.dD("ab_tag", bwVar.mRecomAbTag);
            aqVar.ai("obj_type", bwVar.beY().isChushou ? 2 : 1);
            aqVar.dD("tid", bwVar.getTid());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.beY().live_id);
            aqVar.u("star_id", j);
            aqVar.dD("extra", bwVar.mRecomExtra);
            aqVar.dD("source_from", bwVar.mRecomSource);
            if (this.inQ == 14) {
                aqVar.ai("obj_locate", 1);
            } else if (this.inQ == 13) {
                aqVar.ai("obj_locate", 2);
            }
            s.cbX().e(aqVar);
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icK = i;
    }

    public void yl(int i) {
        this.inQ = i;
    }
}
