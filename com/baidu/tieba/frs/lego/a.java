package com.baidu.tieba.frs.lego;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.lego.card.b;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes2.dex */
public class a extends k<ICardInfo, LegoItemHolder> {
    private ICardInfo jys;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public LegoItemHolder e(ViewGroup viewGroup) {
        e a2 = b.cZu().a(this.mPageContext, this.jys, 1);
        if (a2 == null) {
            return null;
        }
        a2.l(this.mPageId);
        return new LegoItemHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo, LegoItemHolder legoItemHolder) {
        super.a(i, view, viewGroup, (ViewGroup) iCardInfo, (ICardInfo) legoItemHolder);
        View view2 = legoItemHolder.getView();
        if (view2 != null && iCardInfo != null) {
            ((e) view2).aN(iCardInfo);
        }
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.jys = iCardInfo;
        return super.getView(i, view, viewGroup, iCardInfo);
    }
}
