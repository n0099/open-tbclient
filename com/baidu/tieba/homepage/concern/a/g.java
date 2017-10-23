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
    public BdUniqueId aPk;
    private x cVH;
    private com.baidu.tieba.homepage.concern.view.c cVZ;
    private TbPageContext<?> mH;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cVH = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && g.this.cVZ != null && g.this.cVZ.getView() != null && nVar != null && nVar.Nd() != null && !StringUtils.isNull(nVar.Nd().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.cVZ.getHeaderImg() != null && view.getId() == g.this.cVZ.getHeaderImg().getId()) || (g.this.cVZ.Xq() != null && view.getId() == g.this.cVZ.Xq().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 2);
                    akVar.ac("tid", nVar.bee.getTid());
                    akVar.f("fid", nVar.bee.getFid());
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cVZ = new com.baidu.tieba.homepage.concern.view.c(this.mH);
        if (this.aPk != null) {
            this.cVZ.k(this.aPk);
        }
        return new a(this.cVZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.cWb == null) {
            return null;
        }
        nVar.hQ(i + 1);
        u.XN().a(nVar.jt("c12351"));
        aVar.cWb.a(nVar);
        aVar.cWb.b(this.cVH);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c cWb;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.cWb = cVar;
        }
    }
}
