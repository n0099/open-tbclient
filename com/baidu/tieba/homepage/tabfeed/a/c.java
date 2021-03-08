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
    public BdUniqueId fIy;
    private NEGFeedBackView.a gfx;
    ab<com.baidu.tieba.card.data.j> iNL;
    private com.baidu.tieba.card.k klR;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gfx = null;
        this.iNL = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.klR.gpQ != view) {
                    if (view != c.this.klR.hpe.getCommentContainer()) {
                        if (view != c.this.klR.iwm.getCommentContainer()) {
                            if (c.this.klR.csl() != null && view.getId() == c.this.klR.csl().getId()) {
                                i = 2;
                            } else if (c.this.klR.csm() != null && view.getId() == c.this.klR.csm().getId()) {
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
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eLr, c.this.fIy, jVar.csU(), i);
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
        this.klR = new com.baidu.tieba.card.k(this.mPageContext, this.fIy);
        this.klR.wW(2);
        if (this.fIy != null) {
            this.klR.o(this.fIy);
        }
        return new CardViewHolder<>(this.klR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.k> cardViewHolder) {
        jVar.xe(jVar.position + 1);
        com.baidu.tieba.card.k cto = cardViewHolder.cto();
        cto.xb(i + 1);
        cto.a(jVar);
        cto.c(this.iNL);
        cto.b(this.gfx);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eLr, this.fIy, jVar.csU());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return cardViewHolder.getView();
    }
}
