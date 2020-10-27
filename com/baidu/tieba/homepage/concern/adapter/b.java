package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> implements com.baidu.tieba.a.f {
    private String ahu;
    public BdUniqueId fmX;
    private ab igS;
    private com.baidu.tieba.card.l jqd;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.igS = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && b.this.jqd != null && b.this.jqd.getView() != null && kVar != null && kVar.bhz() != null && !StringUtils.isNull(kVar.bhz().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, kVar, view == b.this.jqd.clv() ? 1 : 2);
                    if (view == b.this.jqd.gMs.getCommentContainer() || view == b.this.jqd.hPB.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.aj("obj_locate", 7);
                        aqVar.aj("obj_type", 5);
                        aqVar.dR("tid", kVar.bhz().getTid());
                        aqVar.dR("nid", kVar.bhz().getNid());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> c(ViewGroup viewGroup) {
        this.jqd = new com.baidu.tieba.card.l(this.mPageContext, this.fmX);
        this.jqd.iK(true);
        if (this.fmX != null) {
            this.jqd.o(this.fmX);
        }
        return new com.baidu.tieba.card.a.a<>(this.jqd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (kVar == null || aVar == null || aVar.cmx() == null) {
            return null;
        }
        kVar.wW(i + 1);
        com.baidu.tieba.card.t.clQ().e(kVar.IN("c12351"));
        if (aVar.cmx() instanceof com.baidu.tieba.a.e) {
            aVar.cmx().setPage(this.ahu);
        }
        aVar.cmx().a(kVar);
        aVar.cmx().c(this.igS);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }
}
