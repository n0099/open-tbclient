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
    public BdUniqueId dBk;
    private z fWH;
    private com.baidu.tieba.card.j gXo;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWH = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gXo != null && a.this.gXo.getView() != null && jVar != null && jVar.aAg() != null && !StringUtils.isNull(jVar.aAg().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.gXo.buK() ? 1 : 2);
                    if (view == a.this.gXo.eNm.getCommentContainer() || view == a.this.gXo.eNY.diH.getCommentContainer()) {
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
        this.gXo = new com.baidu.tieba.card.j(this.mPageContext, this.dBk);
        this.gXo.fE(true);
        if (this.dBk != null) {
            this.gXo.m(this.dBk);
        }
        return new com.baidu.tieba.card.a.a<>(this.gXo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.bvK() == null) {
            return null;
        }
        jVar.rt(i + 1);
        com.baidu.tieba.card.r.bvg().d(jVar.zX("c12351"));
        if (aVar.bvK() instanceof com.baidu.tieba.a.e) {
            aVar.bvK().setPage(this.LC);
        }
        aVar.bvK().a(jVar);
        aVar.bvK().c(this.fWH);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }
}
