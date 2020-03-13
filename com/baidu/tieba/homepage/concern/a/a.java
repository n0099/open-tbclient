package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> implements com.baidu.tieba.a.f {
    private String LC;
    public BdUniqueId dBx;
    private z fWU;
    private com.baidu.tieba.card.j gXA;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWU = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gXA != null && a.this.gXA.getView() != null && jVar != null && jVar.aAg() != null && !StringUtils.isNull(jVar.aAg().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.gXA.buL() ? 1 : 2);
                    if (view == a.this.gXA.eNz.getCommentContainer() || view == a.this.gXA.eOl.diU.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.X("obj_locate", 7);
                        anVar.X("obj_type", 5);
                        anVar.cy("tid", jVar.aAg().getTid());
                        TiebaStatic.log(anVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> b(ViewGroup viewGroup) {
        this.gXA = new com.baidu.tieba.card.j(this.mPageContext, this.dBx);
        this.gXA.fE(true);
        if (this.dBx != null) {
            this.gXA.m(this.dBx);
        }
        return new com.baidu.tieba.card.a.a<>(this.gXA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.bvL() == null) {
            return null;
        }
        jVar.rt(i + 1);
        com.baidu.tieba.card.r.bvh().d(jVar.zY("c12351"));
        if (aVar.bvL() instanceof com.baidu.tieba.a.e) {
            aVar.bvL().setPage(this.LC);
        }
        aVar.bvL().a(jVar);
        aVar.bvL().c(this.fWU);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }
}
