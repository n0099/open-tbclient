package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    ab<com.baidu.tieba.card.data.j> iyz;
    private com.baidu.tieba.card.l jSM;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWC = null;
        this.iyz = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.jSM.gfP != view) {
                    if (view != c.this.jSM.hbN.getCommentContainer()) {
                        if (view != c.this.jSM.igX.getCommentContainer()) {
                            if (c.this.jSM.crM() != null && view.getId() == c.this.jSM.crM().getId()) {
                                i = 2;
                            } else if (c.this.jSM.crN() != null && view.getId() == c.this.jSM.crN().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, c.this.fzO, jVar.cst(), i);
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
        this.jSM = new com.baidu.tieba.card.l(this.mPageContext, this.fzO);
        this.jSM.ye(2);
        if (this.fzO != null) {
            this.jSM.o(this.fzO);
        }
        return new com.baidu.tieba.card.a.a<>(this.jSM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        jVar.ym(jVar.position + 1);
        com.baidu.tieba.card.l csN = aVar.csN();
        csN.yj(i + 1);
        csN.a(jVar);
        csN.c(this.iyz);
        csN.b(this.fWC);
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, this.fzO, jVar.cst());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return aVar.getView();
    }
}
