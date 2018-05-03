package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes3.dex */
public class a extends f<ICardInfo, b> {
    private ICardInfo dmq;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        e a = com.baidu.tieba.lego.card.b.aKA().a(this.mPageContext, this.dmq, 1);
        if (a == null) {
            return null;
        }
        a.h(this.mPageId);
        return new b(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ICardInfo iCardInfo, b bVar) {
        super.onFillViewHolder(i, view2, viewGroup, iCardInfo, bVar);
        View view3 = bVar.getView();
        if (view3 != null && iCardInfo != null) {
            ((e) view3).O(iCardInfo);
        }
        return view3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view2, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.dmq = iCardInfo;
        return super.getView(i, view2, viewGroup, iCardInfo);
    }
}
