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
    public BdUniqueId aOu;
    private com.baidu.tieba.homepage.concern.view.c cZL;
    private x cZy;
    private TbPageContext<?> mF;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cZy = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && f.this.cZL != null && f.this.cZL.getView() != null && nVar != null && nVar.MR() != null && !StringUtils.isNull(nVar.MR().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((f.this.cZL.getHeaderImg() != null && view.getId() == f.this.cZL.getHeaderImg().getId()) || (f.this.cZL.XO() != null && view.getId() == f.this.cZL.XO().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 2);
                    akVar.ad("tid", nVar.bcG.getTid());
                    akVar.f("fid", nVar.bcG.getFid());
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
        this.cZL = new com.baidu.tieba.homepage.concern.view.c(this.mF);
        if (this.aOu != null) {
            this.cZL.l(this.aOu);
        }
        return new a(this.cZL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.cZN == null) {
            return null;
        }
        nVar.hJ(i + 1);
        u.Yj().a(nVar.jB("c12351"));
        aVar.cZN.a(nVar);
        aVar.cZN.b(this.cZy);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c cZN;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.cZN = cVar;
        }
    }
}
