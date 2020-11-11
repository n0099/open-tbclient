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
    public BdUniqueId fsQ;
    private ab imQ;
    private com.baidu.tieba.card.k jvY;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.imQ = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.adapter.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && a.this.jvY != null && a.this.jvY.getView() != null && kVar != null && kVar.bjZ() != null && !StringUtils.isNull(kVar.bjZ().getTid())) {
                    com.baidu.tieba.homepage.concern.c.a(view, kVar, view == a.this.jvY.cnW() ? 1 : 2);
                    if (view == a.this.jvY.gSR.getCommentContainer() || view == a.this.jvY.hVy.getCommentContainer()) {
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> c(ViewGroup viewGroup) {
        this.jvY = new com.baidu.tieba.card.k(this.mPageContext, this.fsQ);
        this.jvY.iT(true);
        if (this.fsQ != null) {
            this.jvY.o(this.fsQ);
        }
        return new com.baidu.tieba.card.a.a<>(this.jvY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
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
        if (kVar.bjZ() != null && kVar.bjZ().bmU() != null) {
            aq aqVar = new aq("c14007");
            aqVar.al("obj_locate", 2);
            aqVar.w("obj_param1", kVar.bjZ().bmU().live_id);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }
}
