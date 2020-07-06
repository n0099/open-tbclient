package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    aa<com.baidu.tieba.card.data.j> hfO;
    private com.baidu.tieba.card.k ite;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eTW = null;
        this.hfO = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.ite.fdX != view) {
                    if (view != c.this.ite.fRI.getCommentContainer()) {
                        if (view != c.this.ite.gOF.getCommentContainer()) {
                            if (c.this.ite.bOg() != null && view.getId() == c.this.ite.bOg().getId()) {
                                i = 2;
                            } else if (c.this.ite.bOh() != null && view.getId() == c.this.ite.bOh().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLi, c.this.eyE, jVar.bOM(), i);
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
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.ite = new com.baidu.tieba.card.k(this.mPageContext, this.eyE);
        this.ite.sI(2);
        if (this.eyE != null) {
            this.ite.o(this.eyE);
        }
        return new com.baidu.tieba.card.a.a<>(this.ite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        jVar.sR(jVar.position + 1);
        com.baidu.tieba.card.k bPh = aVar.bPh();
        bPh.sN(i + 1);
        bPh.a(jVar);
        bPh.c(this.hfO);
        bPh.b(this.eTW);
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLi, this.eyE, jVar.bOM());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return aVar.getView();
    }
}
