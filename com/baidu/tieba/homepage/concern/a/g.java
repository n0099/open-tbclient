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
public class g extends com.baidu.adp.widget.ListView.a<n, a> {
    public BdUniqueId aPx;
    private x cVT;
    private com.baidu.tieba.homepage.concern.view.c cWl;
    private TbPageContext<?> mG;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cVT = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && g.this.cWl != null && g.this.cWl.getView() != null && nVar != null && nVar.Nj() != null && !StringUtils.isNull(nVar.Nj().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.cWl.getHeaderImg() != null && view.getId() == g.this.cWl.getHeaderImg().getId()) || (g.this.cWl.Xu() != null && view.getId() == g.this.cWl.Xu().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 2);
                    akVar.ad("tid", nVar.bes.getTid());
                    akVar.f("fid", nVar.bes.getFid());
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cWl = new com.baidu.tieba.homepage.concern.view.c(this.mG);
        if (this.aPx != null) {
            this.cWl.k(this.aPx);
        }
        return new a(this.cWl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.cWn == null) {
            return null;
        }
        nVar.hR(i + 1);
        u.XR().a(nVar.ju("c12351"));
        aVar.cWn.a(nVar);
        aVar.cWn.b(this.cVT);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c cWn;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.cWn = cVar;
        }
    }
}
