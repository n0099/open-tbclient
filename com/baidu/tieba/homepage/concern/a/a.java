package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.z;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> implements com.baidu.tieba.a.f {
    private String Lg;
    public BdUniqueId dxg;
    private z fUE;
    private com.baidu.tieba.card.j gVl;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fUE = new z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gVl != null && a.this.gVl.getView() != null && jVar != null && jVar.axQ() != null && !StringUtils.isNull(jVar.axQ().getTid())) {
                    com.baidu.tieba.homepage.concern.b.a(view, jVar, view == a.this.gVl.bte() ? 1 : 2);
                    if (view == a.this.gVl.eJr.getCommentContainer() || view == a.this.gVl.eKe.deA.getCommentContainer()) {
                        an anVar = new an("c12942");
                        anVar.Z("obj_locate", 7);
                        anVar.Z("obj_type", 5);
                        anVar.cp("tid", jVar.axQ().getTid());
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
        this.gVl = new com.baidu.tieba.card.j(this.mPageContext, this.dxg);
        this.gVl.fx(true);
        if (this.dxg != null) {
            this.gVl.m(this.dxg);
        }
        return new com.baidu.tieba.card.a.a<>(this.gVl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        if (jVar == null || aVar == null || aVar.bue() == null) {
            return null;
        }
        jVar.rm(i + 1);
        com.baidu.tieba.card.r.btA().c(jVar.zH("c12351"));
        if (aVar.bue() instanceof com.baidu.tieba.a.e) {
            aVar.bue().setPage(this.Lg);
        }
        aVar.bue().a(jVar);
        aVar.bue().c(this.fUE);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }
}
