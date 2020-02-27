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
    public BdUniqueId dBj;
    private z fWF;
    private com.baidu.tieba.card.j gXm;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWF = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gXm != null && a.this.gXm.getView() != null && jVar != null && jVar.aAe() != null && !StringUtils.isNull(jVar.aAe().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.gXm.buI() ? 1 : 2);
                    if (view == a.this.gXm.eNl.getCommentContainer() || view == a.this.gXm.eNX.diG.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.X("obj_locate", 7);
                        anVar.X("obj_type", 5);
                        anVar.cy("tid", jVar.aAe().getTid());
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
        this.gXm = new com.baidu.tieba.card.j(this.mPageContext, this.dBj);
        this.gXm.fE(true);
        if (this.dBj != null) {
            this.gXm.m(this.dBj);
        }
        return new com.baidu.tieba.card.a.a<>(this.gXm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.bvI() == null) {
            return null;
        }
        jVar.rt(i + 1);
        com.baidu.tieba.card.r.bve().d(jVar.zX("c12351"));
        if (aVar.bvI() instanceof com.baidu.tieba.a.e) {
            aVar.bvI().setPage(this.LC);
        }
        aVar.bvI().a(jVar);
        aVar.bvI().c(this.fWF);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }
}
