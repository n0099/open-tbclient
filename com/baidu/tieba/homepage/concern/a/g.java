package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<n, a> {
    public BdUniqueId aPq;
    private x ddZ;
    private com.baidu.tieba.homepage.concern.view.c deo;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ddZ = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && g.this.deo != null && g.this.deo.getView() != null && nVar != null && nVar.Np() != null && !StringUtils.isNull(nVar.Np().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.deo.getHeaderImg() != null && view.getId() == g.this.deo.getHeaderImg().getId()) || (g.this.deo.ZA() != null && view.getId() == g.this.deo.ZA().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 2);
                    akVar.ac("tid", nVar.beV.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, nVar.beV.getFid());
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.deo = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aPq != null) {
            this.deo.k(this.aPq);
        }
        return new a(this.deo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.deq == null) {
            return null;
        }
        nVar.ij(i + 1);
        u.ZX().a(nVar.jR("c12351"));
        aVar.deq.a(nVar);
        aVar.deq.b(this.ddZ);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c deq;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.deq = cVar;
        }
    }
}
