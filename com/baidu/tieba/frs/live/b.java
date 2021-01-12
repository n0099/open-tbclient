package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.y;
/* loaded from: classes2.dex */
public class b implements CustomMessageTask.CustomRunnable<bz>, y {
    private int jkI = 3;
    private com.baidu.tieba.frs.b.b jyF;
    private int jyG;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.b.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.jyF = null;
        this.mTbPageTag = null;
        this.jyF = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bz> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof bz)) {
            bz data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                av(data);
                com.baidu.tieba.frs.b.c.cIR().a(this.jyF, data, 1);
                com.baidu.tieba.frs.b.a.a(data, 1, this.mPageId, this.jyF, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                av(data);
                com.baidu.tieba.frs.b.c.cIR().a(this.jyF, data, 2);
                com.baidu.tieba.frs.b.a.a(data, 2, this.mPageId, this.jyF, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                av(data);
                com.baidu.tieba.frs.b.c.cIR().a(this.jyF, data, 4);
                com.baidu.tieba.frs.b.a.a(data, 1, this.mPageId, this.jyF, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                aw(data);
                com.baidu.tieba.frs.b.c.cIR().a(this.jyF, data);
                com.baidu.tieba.frs.b.a.a(data, this.mPageId, this.jyF, this.mTbPageTag);
            }
        }
        return null;
    }

    private void av(bz bzVar) {
        if (bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            long j = 0;
            if (bzVar.bnQ().user_info != null) {
                j = bzVar.bnQ().user_info.ala_id;
            }
            aq aqVar = new aq("c13615");
            aqVar.dW("uid", bzVar.bnx().getUserId());
            aqVar.w("fid", bzVar.getFid());
            aqVar.dW("ab_tag", bzVar.mRecomAbTag);
            aqVar.an("obj_type", bzVar.bnQ().isChushou ? 2 : 1);
            aqVar.dW("tid", bzVar.getTid());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bzVar.bnQ().live_id);
            aqVar.w("star_id", j);
            aqVar.dW("extra", bzVar.mRecomExtra);
            aqVar.dW(VideoPlayActivityConfig.SOURCE_FROM, bzVar.mRecomSource);
            if (this.jyG == 14) {
                aqVar.an("obj_locate", 1);
            } else if (this.jyG == 13) {
                aqVar.an("obj_locate", 2);
            }
            TiebaStatic.log(aqVar);
        }
    }

    private void aw(bz bzVar) {
        if (bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            long j = 0;
            if (bzVar.bnQ().user_info != null) {
                j = bzVar.bnQ().user_info.ala_id;
            }
            aq aqVar = new aq("c13614");
            aqVar.dW("uid", bzVar.bnx().getUserId());
            aqVar.w("fid", bzVar.getFid());
            aqVar.dW("ab_tag", bzVar.mRecomAbTag);
            aqVar.an("obj_type", bzVar.bnQ().isChushou ? 2 : 1);
            aqVar.dW("tid", bzVar.getTid());
            aqVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, bzVar.bnQ().live_id);
            aqVar.w("star_id", j);
            aqVar.dW("extra", bzVar.mRecomExtra);
            aqVar.dW(VideoPlayActivityConfig.SOURCE_FROM, bzVar.mRecomSource);
            if (this.jyG == 14) {
                aqVar.an("obj_locate", 1);
            } else if (this.jyG == 13) {
                aqVar.an("obj_locate", 2);
            }
            s.crj().e(aqVar);
        }
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.jkI = i;
    }

    public void zO(int i) {
        this.jyG = i;
    }
}
