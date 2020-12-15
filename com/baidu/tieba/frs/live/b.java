package com.baidu.tieba.frs.live;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.z;
/* loaded from: classes22.dex */
public class b implements CustomMessageTask.CustomRunnable<by>, z {
    private int jcT = 3;
    private com.baidu.tieba.frs.d.b jqP;
    private int jqQ;
    private BdUniqueId mPageId;
    private TbPageTag mTbPageTag;

    public b(com.baidu.tieba.frs.d.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        this.jqP = null;
        this.mTbPageTag = null;
        this.jqP = bVar;
        this.mTbPageTag = tbPageTag;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<by> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof by)) {
            by data = customMessage.getData();
            if (customMessage.getCmd() == 2921018) {
                av(data);
                com.baidu.tieba.frs.d.c.cJI().a(this.jqP, data, 1);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.jqP, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921016) {
                av(data);
                com.baidu.tieba.frs.d.c.cJI().a(this.jqP, data, 2);
                com.baidu.tieba.frs.d.a.a(data, 2, this.mPageId, this.jqP, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921019) {
                av(data);
                com.baidu.tieba.frs.d.c.cJI().a(this.jqP, data, 4);
                com.baidu.tieba.frs.d.a.a(data, 1, this.mPageId, this.jqP, this.mTbPageTag);
            } else if (customMessage.getCmd() == 2921017) {
                aw(data);
                com.baidu.tieba.frs.d.c.cJI().a(this.jqP, data);
                com.baidu.tieba.frs.d.a.a(data, this.mPageId, this.jqP, this.mTbPageTag);
            }
        }
        return null;
    }

    private void av(by byVar) {
        if (byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            long j = 0;
            if (byVar.bpj().user_info != null) {
                j = byVar.bpj().user_info.ala_id;
            }
            ar arVar = new ar("c13615");
            arVar.dY("uid", byVar.boP().getUserId());
            arVar.w("fid", byVar.getFid());
            arVar.dY("ab_tag", byVar.mRecomAbTag);
            arVar.al("obj_type", byVar.bpj().isChushou ? 2 : 1);
            arVar.dY("tid", byVar.getTid());
            arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, byVar.bpj().live_id);
            arVar.w("star_id", j);
            arVar.dY("extra", byVar.mRecomExtra);
            arVar.dY("source_from", byVar.mRecomSource);
            if (this.jqQ == 14) {
                arVar.al("obj_locate", 1);
            } else if (this.jqQ == 13) {
                arVar.al("obj_locate", 2);
            }
            TiebaStatic.log(arVar);
        }
    }

    private void aw(by byVar) {
        if (byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            long j = 0;
            if (byVar.bpj().user_info != null) {
                j = byVar.bpj().user_info.ala_id;
            }
            ar arVar = new ar("c13614");
            arVar.dY("uid", byVar.boP().getUserId());
            arVar.w("fid", byVar.getFid());
            arVar.dY("ab_tag", byVar.mRecomAbTag);
            arVar.al("obj_type", byVar.bpj().isChushou ? 2 : 1);
            arVar.dY("tid", byVar.getTid());
            arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, byVar.bpj().live_id);
            arVar.w("star_id", j);
            arVar.dY("extra", byVar.mRecomExtra);
            arVar.dY("source_from", byVar.mRecomSource);
            if (this.jqQ == 14) {
                arVar.al("obj_locate", 1);
            } else if (this.jqQ == 13) {
                arVar.al("obj_locate", 2);
            }
            t.csh().e(arVar);
        }
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcT = i;
    }

    public void Bi(int i) {
        this.jqQ = i;
    }
}
