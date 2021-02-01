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
    private NEGFeedBackView.a gdO;
    ab<com.baidu.tieba.card.data.j> iLO;
    private com.baidu.tieba.card.k kjB;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdO = null;
        this.iLO = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.kjB.gnT != view) {
                    if (view != c.this.kjB.hng.getCommentContainer()) {
                        if (view != c.this.kjB.iup.getCommentContainer()) {
                            if (c.this.kjB.crY() != null && view.getId() == c.this.kjB.crY().getId()) {
                                i = 2;
                            } else if (c.this.kjB.crZ() != null && view.getId() == c.this.kjB.crZ().getId()) {
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
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, c.this.fGZ, jVar.csH(), i);
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
        this.kjB = new com.baidu.tieba.card.k(this.mPageContext, this.fGZ);
        this.kjB.wV(2);
        if (this.fGZ != null) {
            this.kjB.o(this.fGZ);
        }
        return new CardViewHolder<>(this.kjB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.k> cardViewHolder) {
        jVar.xd(jVar.position + 1);
        com.baidu.tieba.card.k ctb = cardViewHolder.ctb();
        ctb.xa(i + 1);
        ctb.a(jVar);
        ctb.c(this.iLO);
        ctb.b(this.gdO);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eJQ, this.fGZ, jVar.csH());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return cardViewHolder.getView();
    }
}
