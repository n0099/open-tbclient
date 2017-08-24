package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.a.a<p>> {
    public BdUniqueId aOO;
    private h.a amd;
    private x bkE;
    private p cVD;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amd = null;
        this.bkE = new x<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                u.WU().cA(true);
                if (view != null && b.this.cVD != null && b.this.cVD.getView() != null && b.this.cVD.bIA != null && mVar != null && mVar.MF() != null && !StringUtils.isNull(mVar.MF().getTid())) {
                    if (view.getId() != b.this.cVD.getView().getId()) {
                        if (b.this.cVD.WR() == null || view.getId() != b.this.cVD.WR().getId()) {
                            if (b.this.cVD.getHeaderImg() == null || view.getId() != b.this.cVD.getHeaderImg().getId()) {
                                if (b.this.cVD.WA() != null && b.this.cVD.WA().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.Xr());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.Xr());
                            return;
                        }
                        TiebaStatic.log(mVar.Xq());
                        return;
                    }
                    TiebaStatic.log(mVar.Xo());
                }
            }
        };
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cVD = new p(this.oW);
        this.cVD.WO();
        this.cVD.i(this.aOO);
        return new com.baidu.tieba.card.a.a(this.cVD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.Xv() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.hw(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.Xv().a(mVar);
        aVar.Xv().a(this.amd);
        if (mVar != null) {
            u.WU().a(mVar.Xp());
        }
        aVar.Xv().b(this.bkE);
        return aVar.getView();
    }

    private aj b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        return new aj("c10732").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WY()).r("obj_type", mVar.Xn());
    }

    private aj c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        aj r = new aj("c10707").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WY()).r("obj_type", mVar.Xn());
        if (mVar.MF() != null) {
            bl MF = mVar.MF();
            r.r("obj_name", MF.sV() != null && (MF.sV().aBr() != null || MF.sV().Iv() != null) ? 1 : 0);
        }
        return r;
    }

    private aj d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        return new aj("c10733").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WY()).r("obj_type", mVar.Xn());
    }

    private aj e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        return new aj("c10706").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WY()).r("obj_type", mVar.Xn());
    }

    public void setEventCallback(h.a aVar) {
        this.amd = aVar;
    }
}
