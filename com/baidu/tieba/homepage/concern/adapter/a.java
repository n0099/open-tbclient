package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String aht;
    public BdUniqueId fey;
    private aa hUs;
    private com.baidu.tieba.card.k jdF;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hUs = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && a.this.jdF != null && a.this.jdF.getView() != null && kVar != null && kVar.bfG() != null && !StringUtils.isNull(kVar.bfG().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, kVar, view == a.this.jdF.cio() ? 1 : 2);
                    if (view == a.this.jdF.gAE.getCommentContainer() || view == a.this.jdF.hDf.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.aj("obj_locate", 7);
                        aqVar.aj("obj_type", 5);
                        aqVar.dK("tid", kVar.bfG().getTid());
                        aqVar.dK("nid", kVar.bfG().getNid());
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> c(ViewGroup viewGroup) {
        this.jdF = new com.baidu.tieba.card.k(this.mPageContext, this.fey);
        this.jdF.ix(true);
        if (this.fey != null) {
            this.jdF.o(this.fey);
        }
        return new com.baidu.tieba.card.a.a<>(this.jdF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (kVar == null || aVar == null || aVar.cjq() == null) {
            return null;
        }
        kVar.wD(i + 1);
        com.baidu.tieba.card.s.ciJ().e(kVar.Io("c12351"));
        if (aVar.cjq() instanceof com.baidu.tieba.a.e) {
            aVar.cjq().setPage(this.aht);
        }
        aVar.cjq().a(kVar);
        aVar.cjq().c(this.hUs);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }
}
