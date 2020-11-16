package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    ab<com.baidu.tieba.card.data.j> inF;
    private com.baidu.tieba.card.l jFh;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fOM = null;
        this.inF = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.jFh.fXC != view) {
                    if (view != c.this.jFh.gSy.getCommentContainer()) {
                        if (view != c.this.jFh.hVY.getCommentContainer()) {
                            if (c.this.jFh.cny() != null && view.getId() == c.this.jFh.cny().getId()) {
                                i = 2;
                            } else if (c.this.jFh.cnz() != null && view.getId() == c.this.jFh.cnz().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.evQ, c.this.fsa, jVar.cof(), i);
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
        this.jFh = new com.baidu.tieba.card.l(this.mPageContext, this.fsa);
        this.jFh.xy(2);
        if (this.fsa != null) {
            this.jFh.o(this.fsa);
        }
        return new com.baidu.tieba.card.a.a<>(this.jFh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        jVar.xH(jVar.position + 1);
        com.baidu.tieba.card.l coz = aVar.coz();
        coz.xD(i + 1);
        coz.a(jVar);
        coz.c(this.inF);
        coz.b(this.fOM);
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.evQ, this.fsa, jVar.cof());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return aVar.getView();
    }
}
