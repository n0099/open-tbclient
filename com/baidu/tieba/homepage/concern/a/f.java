package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.a<n, a> {
    public BdUniqueId aOx;
    private x cYE;
    private com.baidu.tieba.homepage.concern.view.c cYR;
    private TbPageContext<?> mF;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cYE = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && f.this.cYR != null && f.this.cYR.getView() != null && nVar != null && nVar.MR() != null && !StringUtils.isNull(nVar.MR().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((f.this.cYR.getHeaderImg() != null && view.getId() == f.this.cYR.getHeaderImg().getId()) || (f.this.cYR.XD() != null && view.getId() == f.this.cYR.XD().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 2);
                    akVar.ad("tid", nVar.bcJ.getTid());
                    akVar.f("fid", nVar.bcJ.getFid());
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cYR = new com.baidu.tieba.homepage.concern.view.c(this.mF);
        if (this.aOx != null) {
            this.cYR.l(this.aOx);
        }
        return new a(this.cYR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.cYT == null) {
            return null;
        }
        nVar.hH(i + 1);
        u.XY().a(nVar.jz("c12351"));
        aVar.cYT.a(nVar);
        aVar.cYT.b(this.cYE);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c cYT;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.cYT = cVar;
        }
    }
}
