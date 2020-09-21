package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String ahc;
    public BdUniqueId eSq;
    private aa hFx;
    private com.baidu.tieba.card.k iOL;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hFx = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && a.this.iOL != null && a.this.iOL.getView() != null && kVar != null && kVar.bcY() != null && !StringUtils.isNull(kVar.bcY().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, kVar, view == a.this.iOL.ceS() ? 1 : 2);
                    if (view == a.this.iOL.gml.getCommentContainer() || view == a.this.iOL.hol.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.ai("obj_locate", 7);
                        aqVar.ai("obj_type", 5);
                        aqVar.dF("tid", kVar.bcY().getTid());
                        aqVar.dF("nid", kVar.bcY().getNid());
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
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> c(ViewGroup viewGroup) {
        this.iOL = new com.baidu.tieba.card.k(this.mPageContext, this.eSq);
        this.iOL.ib(true);
        if (this.eSq != null) {
            this.iOL.o(this.eSq);
        }
        return new com.baidu.tieba.card.a.a<>(this.iOL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (kVar == null || aVar == null || aVar.cfU() == null) {
            return null;
        }
        kVar.vX(i + 1);
        com.baidu.tieba.card.s.cfn().e(kVar.HB("c12351"));
        if (aVar.cfU() instanceof com.baidu.tieba.a.e) {
            aVar.cfU().setPage(this.ahc);
        }
        aVar.cfU().a(kVar);
        aVar.cfU().c(this.hFx);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }
}
