package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String ahu;
    public BdUniqueId fmX;
    private ab igS;
    private com.baidu.tieba.card.k jqb;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.igS = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && a.this.jqb != null && a.this.jqb.getView() != null && kVar != null && kVar.bhz() != null && !StringUtils.isNull(kVar.bhz().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, kVar, view == a.this.jqb.clv() ? 1 : 2);
                    if (view == a.this.jqb.gMs.getCommentContainer() || view == a.this.jqb.hPB.getCommentContainer()) {
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> c(ViewGroup viewGroup) {
        this.jqb = new com.baidu.tieba.card.k(this.mPageContext, this.fmX);
        this.jqb.iK(true);
        if (this.fmX != null) {
            this.jqb.o(this.fmX);
        }
        return new com.baidu.tieba.card.a.a<>(this.jqb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
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
        if (kVar.bhz() != null && kVar.bhz().bku() != null) {
            aq aqVar = new aq("c14007");
            aqVar.aj("obj_locate", 2);
            aqVar.w("obj_param1", kVar.bhz().bku().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }
}
