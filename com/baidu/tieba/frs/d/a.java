package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes3.dex */
public class a extends h<ICardInfo, b> {
    private ICardInfo dAd;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        e a = com.baidu.tieba.lego.card.b.aQa().a(this.mPageContext, this.dAd, 1);
        if (a == null) {
            return null;
        }
        a.h(this.mPageId);
        return new b(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, iCardInfo, bVar);
        View view2 = bVar.getView();
        if (view2 != null && iCardInfo != null) {
            ((e) view2).T(iCardInfo);
        }
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.dAd = iCardInfo;
        return super.getView(i, view, viewGroup, iCardInfo);
    }
}
