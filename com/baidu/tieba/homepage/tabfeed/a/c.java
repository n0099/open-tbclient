package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    private NEGFeedBackView.a fWA;
    public BdUniqueId fzO;
    ab<com.baidu.tieba.card.data.j> iyx;
    private com.baidu.tieba.card.l jSK;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWA = null;
        this.iyx = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.jSK.gfN != view) {
                    if (view != c.this.jSK.hbL.getCommentContainer()) {
                        if (view != c.this.jSK.igV.getCommentContainer()) {
                            if (c.this.jSK.crL() != null && view.getId() == c.this.jSK.crL().getId()) {
                                i = 2;
                            } else if (c.this.jSK.crM() != null && view.getId() == c.this.jSK.crM().getId()) {
                                i = 2;
                            }
                        }
                    } else {
                        i = 5;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, c.this.fzO, jVar.css(), i);
                }
                com.baidu.tieba.homepage.tabfeed.b.a(view, jVar, c.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.mTabName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> c(ViewGroup viewGroup) {
        this.jSK = new com.baidu.tieba.card.l(this.mPageContext, this.fzO);
        this.jSK.ye(2);
        if (this.fzO != null) {
            this.jSK.o(this.fzO);
        }
        return new com.baidu.tieba.card.a.a<>(this.jSK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        jVar.ym(jVar.position + 1);
        com.baidu.tieba.card.l csM = aVar.csM();
        csM.yj(i + 1);
        csM.a(jVar);
        csM.c(this.iyx);
        csM.b(this.fWA);
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, this.fzO, jVar.css());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return aVar.getView();
    }
}
