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
/* loaded from: classes21.dex */
public class b implements CustomMessageTask.CustomRunnable<bw>, y {
    private int ijU = 3;
    private com.baidu.tieba.frs.d.b ivl;
    private int ivm;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.ivl = null;
        this.mTbPageTag = null;
        this.ivl = bVar;
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
                com.baidu.tieba.frs.d.c.cvK().a(this.ivl, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.ivl, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                at(data);
                com.baidu.tieba.frs.d.c.cvK().a(this.ivl, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.ivl, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                at(data);
                com.baidu.tieba.frs.d.c.cvK().a(this.ivl, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.ivl, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                au(data);
                com.baidu.tieba.frs.d.c.cvK().a(this.ivl, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.ivl, this.mTbPageTag);
            }
        }
        return null;
    }

    private void at(bw bwVar) {
        if (bwVar != null && bwVar.bfy() != null && bwVar.bfS() != null) {
            long j = 0;
            if (bwVar.bfS().user_info != null) {
                j = bwVar.bfS().user_info.ala_id;
            }
            aq aqVar = new aq("c13615");
            aqVar.dF("uid", bwVar.bfy().getUserId());
            aqVar.u("fid", bwVar.getFid());
            aqVar.dF("ab_tag", bwVar.mRecomAbTag);
            aqVar.ai("obj_type", bwVar.bfS().isChushou ? 2 : 1);
            aqVar.dF("tid", bwVar.getTid());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.bfS().live_id);
            aqVar.u("star_id", j);
            aqVar.dF("extra", bwVar.mRecomExtra);
            aqVar.dF("source_from", bwVar.mRecomSource);
            if (this.ivm == 14) {
                aqVar.ai("obj_locate", 1);
            } else if (this.ivm == 13) {
                aqVar.ai("obj_locate", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void au(bw bwVar) {
        if (bwVar != null && bwVar.bfy() != null && bwVar.bfS() != null) {
            long j = 0;
            if (bwVar.bfS().user_info != null) {
                j = bwVar.bfS().user_info.ala_id;
            }
            aq aqVar = new aq("c13614");
            aqVar.dF("uid", bwVar.bfy().getUserId());
            aqVar.u("fid", bwVar.getFid());
            aqVar.dF("ab_tag", bwVar.mRecomAbTag);
            aqVar.ai("obj_type", bwVar.bfS().isChushou ? 2 : 1);
            aqVar.dF("tid", bwVar.getTid());
            aqVar.u(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bwVar.bfS().live_id);
            aqVar.u("star_id", j);
            aqVar.dF("extra", bwVar.mRecomExtra);
            aqVar.dF("source_from", bwVar.mRecomSource);
            if (this.ivm == 14) {
                aqVar.ai("obj_locate", 1);
            } else if (this.ivm == 13) {
                aqVar.ai("obj_locate", 2);
            }
            s.cfn().e(aqVar);
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.ijU = i;
    }

    public void yK(int i) {
        this.ivm = i;
    }
}
