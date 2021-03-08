package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.z;
/* loaded from: classes2.dex */
public class b implements CustomMessageTask.CustomRunnable<cb>, z {
    private com.baidu.tieba.frs.b.b jGh;
    private int jGi;
    private int jsm = 3;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.b.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.jGh = null;
        this.mTbPageTag = null;
        this.jGh = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<cb> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof cb)) {
            cb data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                aw(data);
                com.baidu.tieba.frs.b.c.cKr().a(this.jGh, data, 1);
                com.baidu.tieba.frs.b.a.a(data, 1, this.mPageId, this.jGh, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                aw(data);
                com.baidu.tieba.frs.b.c.cKr().a(this.jGh, data, 2);
                com.baidu.tieba.frs.b.a.a(data, 2, this.mPageId, this.jGh, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                aw(data);
                com.baidu.tieba.frs.b.c.cKr().a(this.jGh, data, 4);
                com.baidu.tieba.frs.b.a.a(data, 1, this.mPageId, this.jGh, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                ax(data);
                com.baidu.tieba.frs.b.c.cKr().a(this.jGh, data);
                com.baidu.tieba.frs.b.a.a(data, this.mPageId, this.jGh, this.mTbPageTag);
            }
        }
        return null;
    }

    private void aw(cb cbVar) {
        if (cbVar != null && cbVar.bnS() != null && cbVar.bol() != null) {
            long j = 0;
            if (cbVar.bol().user_info != null) {
                j = cbVar.bol().user_info.ala_id;
            }
            ar arVar = new ar("c13615");
            arVar.dR("uid", cbVar.bnS().getUserId());
            arVar.v("fid", cbVar.getFid());
            arVar.dR("ab_tag", cbVar.mRecomAbTag);
            arVar.aq("obj_type", cbVar.bol().isChushou ? 2 : 1);
            arVar.dR("tid", cbVar.getTid());
            arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, cbVar.bol().live_id);
            arVar.v("star_id", j);
            arVar.dR("extra", cbVar.mRecomExtra);
            arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, cbVar.mRecomSource);
            if (this.jGi == 14) {
                arVar.aq("obj_locate", 1);
            } else if (this.jGi == 13) {
                arVar.aq("obj_locate", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void ax(cb cbVar) {
        if (cbVar != null && cbVar.bnS() != null && cbVar.bol() != null) {
            long j = 0;
            if (cbVar.bol().user_info != null) {
                j = cbVar.bol().user_info.ala_id;
            }
            ar arVar = new ar("c13614");
            arVar.dR("uid", cbVar.bnS().getUserId());
            arVar.v("fid", cbVar.getFid());
            arVar.dR("ab_tag", cbVar.mRecomAbTag);
            arVar.aq("obj_type", cbVar.bol().isChushou ? 2 : 1);
            arVar.dR("tid", cbVar.getTid());
            arVar.v(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, cbVar.bol().live_id);
            arVar.v("star_id", j);
            arVar.dR("extra", cbVar.mRecomExtra);
            arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, cbVar.mRecomSource);
            if (this.jGi == 14) {
                arVar.aq("obj_locate", 1);
            } else if (this.jGi == 13) {
                arVar.aq("obj_locate", 2);
            }
            t.csH().e(arVar);
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
        this.jsm = i;
    }

    public void zY(int i) {
        this.jGi = i;
    }
}
