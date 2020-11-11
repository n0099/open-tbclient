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
    public BdUniqueId fsQ;
    private ab imQ;
    private com.baidu.tieba.card.l jwa;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.imQ = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && b.this.jwa != null && b.this.jwa.getView() != null && kVar != null && kVar.bjZ() != null && !StringUtils.isNull(kVar.bjZ().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, kVar, view == b.this.jwa.cnW() ? 1 : 2);
                    if (view == b.this.jwa.gSR.getCommentContainer() || view == b.this.jwa.hVy.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.al("obj_locate", 7);
                        aqVar.al("obj_type", 5);
                        aqVar.dR("tid", kVar.bjZ().getTid());
                        aqVar.dR("nid", kVar.bjZ().getNid());
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
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> c(ViewGroup viewGroup) {
        this.jwa = new com.baidu.tieba.card.l(this.mPageContext, this.fsQ);
        this.jwa.iT(true);
        if (this.fsQ != null) {
            this.jwa.o(this.fsQ);
        }
        return new com.baidu.tieba.card.a.a<>(this.jwa);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (kVar == null || aVar == null || aVar.coY() == null) {
            return null;
        }
        kVar.xj(i + 1);
        com.baidu.tieba.card.t.cor().e(kVar.Je("c12351"));
        if (aVar.coY() instanceof com.baidu.tieba.a.e) {
            aVar.coY().setPage(this.ahu);
        }
        aVar.coY().a(kVar);
        aVar.coY().c(this.imQ);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }
}
