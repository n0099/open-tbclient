package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.y;
/* loaded from: classes9.dex */
public class b implements CustomMessageTask.CustomRunnable<bu>, y {
    private int hID = 3;
    private com.baidu.tieba.frs.d.b hTG;
    private int hTH;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.hTG = null;
        this.mTbPageTag = null;
        this.hTG = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bu> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bu)) {
            bu data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                av(data);
                com.baidu.tieba.frs.d.c.cer().a(this.hTG, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hTG, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                av(data);
                com.baidu.tieba.frs.d.c.cer().a(this.hTG, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.hTG, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                av(data);
                com.baidu.tieba.frs.d.c.cer().a(this.hTG, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.hTG, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                aw(data);
                com.baidu.tieba.frs.d.c.cer().a(this.hTG, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.hTG, this.mTbPageTag);
            }
        }
        return null;
    }

    private void av(bu buVar) {
        if (buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            long j = 0;
            if (buVar.aSJ().user_info != null) {
                j = buVar.aSJ().user_info.ala_id;
            }
            ao aoVar = new ao("c13615");
            aoVar.dk("uid", buVar.aSp().getUserId());
            aoVar.s("fid", buVar.getFid());
            aoVar.dk("ab_tag", buVar.mRecomAbTag);
            aoVar.ag("obj_type", buVar.aSJ().isChushou ? 2 : 1);
            aoVar.dk("tid", buVar.getTid());
            aoVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, buVar.aSJ().live_id);
            aoVar.s("star_id", j);
            aoVar.dk("extra", buVar.mRecomExtra);
            aoVar.dk("source_from", buVar.mRecomSource);
            if (this.hTH == 14) {
                aoVar.ag("obj_locate", 1);
            } else if (this.hTH == 13) {
                aoVar.ag("obj_locate", 2);
            }
            TiebaStatic.log(aoVar);
        }
    }

    private void aw(bu buVar) {
        if (buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            long j = 0;
            if (buVar.aSJ().user_info != null) {
                j = buVar.aSJ().user_info.ala_id;
            }
            ao aoVar = new ao("c13614");
            aoVar.dk("uid", buVar.aSp().getUserId());
            aoVar.s("fid", buVar.getFid());
            aoVar.dk("ab_tag", buVar.mRecomAbTag);
            aoVar.ag("obj_type", buVar.aSJ().isChushou ? 2 : 1);
            aoVar.dk("tid", buVar.getTid());
            aoVar.s(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, buVar.aSJ().live_id);
            aoVar.s("star_id", j);
            aoVar.dk("extra", buVar.mRecomExtra);
            aoVar.dk("source_from", buVar.mRecomSource);
            if (this.hTH == 14) {
                aoVar.ag("obj_locate", 1);
            } else if (this.hTH == 13) {
                aoVar.ag("obj_locate", 2);
            }
            s.bOB().e(aoVar);
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.hID = i;
    }

    public void vA(int i) {
        this.hTH = i;
    }
}
