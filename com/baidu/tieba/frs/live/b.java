package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.z;
/* loaded from: classes21.dex */
public class b implements CustomMessageTask.CustomRunnable<bx>, z {
    private int iRX = 3;
    private com.baidu.tieba.frs.d.b jdk;
    private int jdl;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.jdk = null;
        this.mTbPageTag = null;
        this.jdk = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bx> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bx)) {
            bx data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                av(data);
                com.baidu.tieba.frs.d.c.cEu().a(this.jdk, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.jdk, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                av(data);
                com.baidu.tieba.frs.d.c.cEu().a(this.jdk, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.jdk, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                av(data);
                com.baidu.tieba.frs.d.c.cEu().a(this.jdk, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.jdk, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                aw(data);
                com.baidu.tieba.frs.d.c.cEu().a(this.jdk, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.jdk, this.mTbPageTag);
            }
        }
        return null;
    }

    private void av(bx bxVar) {
        if (bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
            long j = 0;
            if (bxVar.blW().user_info != null) {
                j = bxVar.blW().user_info.ala_id;
            }
            ar arVar = new ar("c13615");
            arVar.dR("uid", bxVar.blC().getUserId());
            arVar.w("fid", bxVar.getFid());
            arVar.dR("ab_tag", bxVar.mRecomAbTag);
            arVar.ak("obj_type", bxVar.blW().isChushou ? 2 : 1);
            arVar.dR("tid", bxVar.getTid());
            arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bxVar.blW().live_id);
            arVar.w("star_id", j);
            arVar.dR("extra", bxVar.mRecomExtra);
            arVar.dR("source_from", bxVar.mRecomSource);
            if (this.jdl == 14) {
                arVar.ak("obj_locate", 1);
            } else if (this.jdl == 13) {
                arVar.ak("obj_locate", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void aw(bx bxVar) {
        if (bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
            long j = 0;
            if (bxVar.blW().user_info != null) {
                j = bxVar.blW().user_info.ala_id;
            }
            ar arVar = new ar("c13614");
            arVar.dR("uid", bxVar.blC().getUserId());
            arVar.w("fid", bxVar.getFid());
            arVar.dR("ab_tag", bxVar.mRecomAbTag);
            arVar.ak("obj_type", bxVar.blW().isChushou ? 2 : 1);
            arVar.dR("tid", bxVar.getTid());
            arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bxVar.blW().live_id);
            arVar.w("star_id", j);
            arVar.dR("extra", bxVar.mRecomExtra);
            arVar.dR("source_from", bxVar.mRecomSource);
            if (this.jdl == 14) {
                arVar.ak("obj_locate", 1);
            } else if (this.jdl == 13) {
                arVar.ak("obj_locate", 2);
            }
            t.cnT().e(arVar);
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRX = i;
    }

    public void Au(int i) {
        this.jdl = i;
    }
}
