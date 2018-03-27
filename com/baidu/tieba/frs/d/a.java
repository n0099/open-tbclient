package com.baidu.tieba.frs.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.lego.card.e.k;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes3.dex */
public class a extends g<ICardInfo, b> {
    private ICardInfo dSj;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        k a = com.baidu.tieba.lego.card.b.aPz().a(this.mPageContext, this.dSj, 1);
        if (a == null) {
            return null;
        }
        a.h(this.mPageId);
        return new b(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, iCardInfo, bVar);
        View view2 = bVar.getView();
        if (view2 != null && iCardInfo != null) {
            ((k) view2).aT(iCardInfo);
        }
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.dSj = iCardInfo;
        return super.getView(i, view, viewGroup, iCardInfo);
    }
}
