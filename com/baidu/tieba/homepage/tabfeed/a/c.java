package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, CardViewHolder<com.baidu.tieba.card.k>> {
    public BdUniqueId fEN;
    private NEGFeedBackView.a gbz;
    aa<com.baidu.tieba.card.data.j> iGf;
    private com.baidu.tieba.card.k kbr;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbz = null;
        this.iGf = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.kbr.gln != view) {
                    if (view != c.this.kbr.hiT.getCommentContainer()) {
                        if (view != c.this.kbr.ioL.getCommentContainer()) {
                            if (c.this.kbr.cqO() != null && view.getId() == c.this.kbr.cqO().getId()) {
                                i = 2;
                            } else if (c.this.kbr.cqP() != null && view.getId() == c.this.kbr.cqP().getId()) {
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
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eHK, c.this.fEN, jVar.crv(), i);
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
        this.kbr = new com.baidu.tieba.card.k(this.mPageContext, this.fEN);
        this.kbr.wL(2);
        if (this.fEN != null) {
            this.kbr.o(this.fEN);
        }
        return new CardViewHolder<>(this.kbr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.k> cardViewHolder) {
        jVar.wT(jVar.position + 1);
        com.baidu.tieba.card.k crP = cardViewHolder.crP();
        crP.wQ(i + 1);
        crP.a(jVar);
        crP.c(this.iGf);
        crP.b(this.gbz);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eHK, this.fEN, jVar.crv());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return cardViewHolder.getView();
    }
}
