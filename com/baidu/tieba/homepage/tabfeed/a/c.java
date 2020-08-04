package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId eEU;
    private NEGFeedBackView.a far;
    aa<com.baidu.tieba.card.data.j> hly;
    private com.baidu.tieba.card.k izk;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.far = null;
        this.hly = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.izk.fiQ != view) {
                    if (view != c.this.izk.fXb.getCommentContainer()) {
                        if (view != c.this.izk.gUl.getCommentContainer()) {
                            if (c.this.izk.bRq() != null && view.getId() == c.this.izk.bRq().getId()) {
                                i = 2;
                            } else if (c.this.izk.bRr() != null && view.getId() == c.this.izk.bRr().getId()) {
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
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLK, c.this.eEU, jVar.bRX(), i);
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> b(ViewGroup viewGroup) {
        this.izk = new com.baidu.tieba.card.k(this.mPageContext, this.eEU);
        this.izk.ta(2);
        if (this.eEU != null) {
            this.izk.p(this.eEU);
        }
        return new com.baidu.tieba.card.a.a<>(this.izk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        jVar.tj(jVar.position + 1);
        com.baidu.tieba.card.k bSs = aVar.bSs();
        bSs.tf(i + 1);
        bSs.a(jVar);
        bSs.c(this.hly);
        bSs.b(this.far);
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.dLK, this.eEU, jVar.bRX());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return aVar.getView();
    }
}
