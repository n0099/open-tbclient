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
    public BdUniqueId fJu;
    private NEGFeedBackView.a ggi;
    aa<com.baidu.tieba.card.data.j> iKM;
    private com.baidu.tieba.card.k kfX;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ggi = null;
        this.iKM = new aa<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.tabfeed.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.kfX.gpU != view) {
                    if (view != c.this.kfX.hnz.getCommentContainer()) {
                        if (view != c.this.kfX.its.getCommentContainer()) {
                            if (c.this.kfX.cuF() != null && view.getId() == c.this.kfX.cuF().getId()) {
                                i = 2;
                            } else if (c.this.kfX.cuG() != null && view.getId() == c.this.kfX.cuG().getId()) {
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
                    com.baidu.tieba.homepage.personalize.a.a.a(jVar.eMv, c.this.fJu, jVar.cvm(), i);
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
        this.kfX = new com.baidu.tieba.card.k(this.mPageContext, this.fJu);
        this.kfX.ys(2);
        if (this.fJu != null) {
            this.kfX.o(this.fJu);
        }
        return new CardViewHolder<>(this.kfX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, CardViewHolder<com.baidu.tieba.card.k> cardViewHolder) {
        jVar.yA(jVar.position + 1);
        com.baidu.tieba.card.k cvG = cardViewHolder.cvG();
        cvG.yx(i + 1);
        cvG.a(jVar);
        cvG.c(this.iKM);
        cvG.b(this.ggi);
        com.baidu.tieba.homepage.personalize.a.a.a(jVar.eMv, this.fJu, jVar.cvm());
        com.baidu.tieba.homepage.tabfeed.b.a(jVar, this.mTabName);
        return cardViewHolder.getView();
    }
}
