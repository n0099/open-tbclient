package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.a.a<p>> {
    public BdUniqueId aPx;
    private c.a aVH;
    private x bmJ;
    private p cZp;
    private TbPageContext<?> mG;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVH = null;
        this.bmJ = new x<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                u.XR().cB(true);
                if (view != null && b.this.cZp != null && b.this.cZp.getView() != null && b.this.cZp.bLI != null && mVar != null && mVar.Nj() != null && !StringUtils.isNull(mVar.Nj().getTid())) {
                    if (view.getId() != b.this.cZp.getView().getId()) {
                        if (b.this.cZp.XO() == null || view.getId() != b.this.cZp.XO().getId()) {
                            if (b.this.cZp.getHeaderImg() == null || view.getId() != b.this.cZp.getHeaderImg().getId()) {
                                if (b.this.cZp.Xu() != null && b.this.cZp.Xu().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.Yn());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.Yn());
                            return;
                        }
                        TiebaStatic.log(mVar.Ym());
                        return;
                    }
                    TiebaStatic.log(mVar.Yk());
                }
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cZp = new p(this.mG);
        this.cZp.XL();
        this.cZp.h(this.aPx);
        return new com.baidu.tieba.card.a.a(this.cZp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.Yr() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.hR(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.Yr().a(mVar);
        aVar.Yr().a(this.aVH);
        if (mVar != null) {
            u.XR().a(mVar.Yl());
        }
        aVar.Yr().b(this.bmJ);
        return aVar.getView();
    }

    private ak b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nj() == null) {
            return null;
        }
        return new ak("c10732").ad("fid", String.valueOf(mVar.Nj().getFid())).ad("tid", String.valueOf(mVar.Nj().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XU()).r("obj_type", mVar.Yj()).ad("obj_id", mVar.getExtra());
    }

    private ak c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nj() == null) {
            return null;
        }
        ak ad = new ak("c10707").ad("fid", String.valueOf(mVar.Nj().getFid())).ad("tid", String.valueOf(mVar.Nj().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XU()).r("obj_type", mVar.Yj()).ad("obj_id", mVar.getExtra());
        if (mVar.Nj() != null) {
            bh Nj = mVar.Nj();
            ad.r("obj_name", Nj.sL() != null && (Nj.sL().aCd() != null || Nj.sL().IL() != null) ? 1 : 0);
        }
        return ad;
    }

    private ak d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nj() == null) {
            return null;
        }
        return new ak("c10733").ad("fid", String.valueOf(mVar.Nj().getFid())).ad("tid", String.valueOf(mVar.Nj().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XU()).r("obj_type", mVar.Yj()).ad("obj_id", mVar.getExtra());
    }

    private ak e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nj() == null) {
            return null;
        }
        return new ak("c10706").ad("fid", String.valueOf(mVar.Nj().getFid())).ad("tid", String.valueOf(mVar.Nj().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XU()).r("obj_type", mVar.Yj()).ad("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.aVH = aVar;
    }
}
