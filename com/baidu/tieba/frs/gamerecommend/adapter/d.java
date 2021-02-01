package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.f;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.d, CardViewHolder<com.baidu.tieba.card.f>> {
    private ab jze;
    private com.baidu.tieba.card.f jzo;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.d.iDY);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.f> e(ViewGroup viewGroup) {
        this.jzo = new com.baidu.tieba.card.f(this.mPageContext, this.mForumId);
        return new CardViewHolder<>(this.jzo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.d dVar, CardViewHolder<com.baidu.tieba.card.f> cardViewHolder) {
        if (cardViewHolder.ctb() == null) {
            return null;
        }
        cardViewHolder.ctb().a(dVar);
        cardViewHolder.ctb().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.ctb().a(new f.a() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.d.1
            @Override // com.baidu.tieba.card.f.a
            public void b(View view2, BaseCardInfo baseCardInfo) {
                if (d.this.jze != null) {
                    d.this.jze.a(view2, baseCardInfo);
                }
            }
        });
        return cardViewHolder.ctb().getView();
    }

    public void d(ab abVar) {
        this.jze = abVar;
    }
}
