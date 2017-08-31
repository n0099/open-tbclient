package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.a.a<p>> {
    public BdUniqueId aOx;
    private h.a alx;
    private x bkZ;
    private p dcg;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alx = null;
        this.bkZ = new x<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                u.XY().cC(true);
                if (view != null && b.this.dcg != null && b.this.dcg.getView() != null && b.this.dcg.bLu != null && mVar != null && mVar.MR() != null && !StringUtils.isNull(mVar.MR().getTid())) {
                    if (view.getId() != b.this.dcg.getView().getId()) {
                        if (b.this.dcg.XV() == null || view.getId() != b.this.dcg.XV().getId()) {
                            if (b.this.dcg.getHeaderImg() == null || view.getId() != b.this.dcg.getHeaderImg().getId()) {
                                if (b.this.dcg.XD() != null && b.this.dcg.XD().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.Yu());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.Yu());
                            return;
                        }
                        TiebaStatic.log(mVar.Yt());
                        return;
                    }
                    TiebaStatic.log(mVar.Yr());
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dcg = new p(this.mF);
        this.dcg.XS();
        this.dcg.i(this.aOx);
        return new com.baidu.tieba.card.a.a(this.dcg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.Yy() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.hH(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.Yy().a(mVar);
        aVar.Yy().a(this.alx);
        if (mVar != null) {
            u.XY().a(mVar.Ys());
        }
        aVar.Yy().b(this.bkZ);
        return aVar.getView();
    }

    private ak b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MR() == null) {
            return null;
        }
        return new ak("c10732").ad("fid", String.valueOf(mVar.MR().getFid())).ad("tid", String.valueOf(mVar.MR().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.Yb()).r("obj_type", mVar.Yq());
    }

    private ak c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MR() == null) {
            return null;
        }
        ak r = new ak("c10707").ad("fid", String.valueOf(mVar.MR().getFid())).ad("tid", String.valueOf(mVar.MR().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.Yb()).r("obj_type", mVar.Yq());
        if (mVar.MR() != null) {
            bj MR = mVar.MR();
            r.r("obj_name", MR.sR() != null && (MR.sR().aDg() != null || MR.sR().ID() != null) ? 1 : 0);
        }
        return r;
    }

    private ak d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MR() == null) {
            return null;
        }
        return new ak("c10733").ad("fid", String.valueOf(mVar.MR().getFid())).ad("tid", String.valueOf(mVar.MR().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.Yb()).r("obj_type", mVar.Yq());
    }

    private ak e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MR() == null) {
            return null;
        }
        return new ak("c10706").ad("fid", String.valueOf(mVar.MR().getFid())).ad("tid", String.valueOf(mVar.MR().getTid())).ad("obj_param1", mVar.getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.Yb()).r("obj_type", mVar.Yq());
    }

    public void setEventCallback(h.a aVar) {
        this.alx = aVar;
    }
}
