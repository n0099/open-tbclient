package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.z;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> implements com.baidu.tieba.a.f {
    private String La;
    public BdUniqueId dwY;
    private z fRu;
    private com.baidu.tieba.card.j gRR;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fRu = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gRR != null && a.this.gRR.getView() != null && jVar != null && jVar.axx() != null && !StringUtils.isNull(jVar.axx().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.gRR.bsc() ? 1 : 2);
                    if (view == a.this.gRR.eIh.getCommentContainer() || view == a.this.gRR.eIU.dep.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.Z("obj_locate", 7);
                        anVar.Z("obj_type", 5);
                        anVar.cp("tid", jVar.axx().getTid());
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
    /* renamed from: ar */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> b(ViewGroup viewGroup) {
        this.gRR = new com.baidu.tieba.card.j(this.mPageContext);
        this.gRR.fs(true);
        if (this.dwY != null) {
            this.gRR.m(this.dwY);
        }
        return new com.baidu.tieba.card.a.a<>(this.gRR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.btc() == null) {
            return null;
        }
        jVar.rh(i + 1);
        com.baidu.tieba.card.r.bsy().c(jVar.zx("c12351"));
        if (aVar.btc() instanceof com.baidu.tieba.a.e) {
            aVar.btc().setPage(this.La);
        }
        aVar.btc().a(jVar);
        aVar.btc().c(this.fRu);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }
}
