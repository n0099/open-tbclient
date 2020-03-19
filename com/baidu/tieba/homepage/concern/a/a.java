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
    public BdUniqueId dBK;
    private z fXC;
    private com.baidu.tieba.card.j gYH;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fXC = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gYH != null && a.this.gYH.getView() != null && jVar != null && jVar.aAj() != null && !StringUtils.isNull(jVar.aAj().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.gYH.buQ() ? 1 : 2);
                    if (view == a.this.gYH.eNX.getCommentContainer() || view == a.this.gYH.eOJ.djh.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.X("obj_locate", 7);
                        anVar.X("obj_type", 5);
                        anVar.cx("tid", jVar.aAj().getTid());
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
    /* renamed from: aw */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> b(ViewGroup viewGroup) {
        this.gYH = new com.baidu.tieba.card.j(this.mPageContext, this.dBK);
        this.gYH.fF(true);
        if (this.dBK != null) {
            this.gYH.m(this.dBK);
        }
        return new com.baidu.tieba.card.a.a<>(this.gYH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.bvQ() == null) {
            return null;
        }
        jVar.rv(i + 1);
        com.baidu.tieba.card.r.bvm().e(jVar.Aa("c12351"));
        if (aVar.bvQ() instanceof com.baidu.tieba.a.e) {
            aVar.bvQ().setPage(this.LC);
        }
        aVar.bvQ().a(jVar);
        aVar.bvQ().c(this.fXC);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wQ(String str) {
        this.LC = str;
    }
}
