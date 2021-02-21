package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, CardViewHolder<com.baidu.tieba.card.k>> {
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdT;
    ab<com.baidu.tieba.card.data.j> iMc;
    private com.baidu.tieba.card.k kjP;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdT = null;
        this.iMc = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.kjP.goh != view) {
                    if (view != c.this.kjP.hnu.getCommentContainer()) {
                        if (view != c.this.kjP.iuD.getCommentContainer()) {
                            if (c.this.kjP.csf() != null && view.getId() == c.this.kjP.csf().getId()) {
                                i = 2;
                            } else if (c.this.kjP.csg() != null && view.getId() == c.this.kjP.csg().getId()) {
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
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, c.this.fGZ, jVar.csO(), i);
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
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.k> e(ViewGroup viewGroup) {
        this.kjP = new com.baidu.tieba.card.k(this.mPageContext, this.fGZ);
        this.kjP.wV(2);
        if (this.fGZ != null) {
            this.kjP.o(this.fGZ);
        }
        return new CardViewHolder<>(this.kjP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.k> cardViewHolder) {
        jVar.xd(jVar.position + 1);
        com.baidu.tieba.card.k cti = cardViewHolder.cti();
        cti.xa(i + 1);
        cti.a(jVar);
        cti.c(this.iMc);
        cti.b(this.gdT);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, this.fGZ, jVar.csO());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return cardViewHolder.getView();
    }
}
