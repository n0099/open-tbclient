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
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<n, a> {
    public BdUniqueId aSv;
    private v dmZ;
    private com.baidu.tieba.homepage.concern.view.c dnq;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dmZ = new v<n>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                if (view != null && h.this.dnq != null && h.this.dnq.getView() != null && nVar != null && nVar.Ox() != null && !StringUtils.isNull(nVar.Ox().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((h.this.dnq.getHeaderImg() != null && view.getId() == h.this.dnq.getHeaderImg().getId()) || (h.this.dnq.abv() != null && view.getId() == h.this.dnq.abv().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 2);
                    akVar.ac("tid", nVar.bjD.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, nVar.bjD.getFid());
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
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dnq = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aSv != null) {
            this.dnq.k(this.aSv);
        }
        return new a(this.dnq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.dns == null) {
            return null;
        }
        nVar.iE(i + 1);
        s.abU().a(nVar.jY("c12351"));
        aVar.dns.a(nVar);
        aVar.dns.b(this.dmZ);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c dns;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.dns = cVar;
        }
    }
}
