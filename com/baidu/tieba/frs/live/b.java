package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.y;
/* loaded from: classes9.dex */
public class b implements CustomMessageTask.CustomRunnable<bk>, y {
    private com.baidu.tieba.frs.d.b hGt;
    private int hGu;
    private int hvK = 3;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.hGt = null;
        this.mTbPageTag = null;
        this.hGt = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bk> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bk)) {
            bk data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                av(data);
                com.baidu.tieba.frs.d.c.caY().a(this.hGt, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hGt, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                av(data);
                com.baidu.tieba.frs.d.c.caY().a(this.hGt, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.hGt, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                av(data);
                com.baidu.tieba.frs.d.c.caY().a(this.hGt, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hGt, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                aw(data);
                com.baidu.tieba.frs.d.c.caY().a(this.hGt, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.hGt, this.mTbPageTag);
            }
        }
        return null;
    }

    private void av(bk bkVar) {
        if (bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            long j = 0;
            if (bkVar.aQS().user_info != null) {
                j = bkVar.aQS().user_info.ala_id;
            }
            an anVar = new an("c13615");
            anVar.dh("uid", bkVar.aQx().getUserId());
            anVar.s("fid", bkVar.getFid());
            anVar.dh("ab_tag", bkVar.mRecomAbTag);
            anVar.ag("obj_type", bkVar.aQS().isChushou ? 2 : 1);
            anVar.dh("tid", bkVar.getTid());
            anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bkVar.aQS().live_id);
            anVar.s("star_id", j);
            anVar.dh("extra", bkVar.mRecomExtra);
            anVar.dh("source_from", bkVar.mRecomSource);
            if (this.hGu == 14) {
                anVar.ag("obj_locate", 1);
            } else if (this.hGu == 13) {
                anVar.ag("obj_locate", 2);
            }
            TiebaStatic.log(anVar);
        }
    }

    private void aw(bk bkVar) {
        if (bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            long j = 0;
            if (bkVar.aQS().user_info != null) {
                j = bkVar.aQS().user_info.ala_id;
            }
            an anVar = new an("c13614");
            anVar.dh("uid", bkVar.aQx().getUserId());
            anVar.s("fid", bkVar.getFid());
            anVar.dh("ab_tag", bkVar.mRecomAbTag);
            anVar.ag("obj_type", bkVar.aQS().isChushou ? 2 : 1);
            anVar.dh("tid", bkVar.getTid());
            anVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bkVar.aQS().live_id);
            anVar.s("star_id", j);
            anVar.dh("extra", bkVar.mRecomExtra);
            anVar.dh("source_from", bkVar.mRecomSource);
            if (this.hGu == 14) {
                anVar.ag("obj_locate", 1);
            } else if (this.hGu == 13) {
                anVar.ag("obj_locate", 2);
            }
            s.bLs().e(anVar);
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.hvK = i;
    }

    public void uV(int i) {
        this.hGu = i;
    }
}
