package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> implements com.baidu.tieba.a.f {
    private String afG;
    public BdUniqueId eyE;
    private aa hfO;
    private com.baidu.tieba.card.k imA;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hfO = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.imA != null && a.this.imA.getView() != null && jVar != null && jVar.aPS() != null && !StringUtils.isNull(jVar.aPS().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.imA.bOg() ? 1 : 2);
                    if (view == a.this.imA.fRI.getCommentContainer() || view == a.this.imA.gOF.getCommentContainer()) {
                        ao aoVar = new ao("c12942");
                        aoVar.ag("obj_locate", 7);
                        aoVar.ag("obj_type", 5);
                        aoVar.dk("tid", jVar.aPS().getTid());
                        aoVar.dk("nid", jVar.aPS().getNid());
                        TiebaStatic.log(aoVar);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.imA = new com.baidu.tieba.card.k(this.mPageContext, this.eyE);
        this.imA.hd(true);
        if (this.eyE != null) {
            this.imA.o(this.eyE);
        }
        return new com.baidu.tieba.card.a.a<>(this.imA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        if (jVar == null || aVar == null || aVar.bPh() == null) {
            return null;
        }
        jVar.sR(i + 1);
        com.baidu.tieba.card.s.bOB().e(jVar.DT("c12351"));
        if (aVar.bPh() instanceof com.baidu.tieba.a.e) {
            aVar.bPh().setPage(this.afG);
        }
        aVar.bPh().a(jVar);
        aVar.bPh().c(this.hfO);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}
