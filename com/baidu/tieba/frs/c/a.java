package com.baidu.tieba.frs.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.e;
/* loaded from: classes22.dex */
public class a extends k<ICardInfo, b> {
    private ICardInfo jqA;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bz */
    public b c(ViewGroup viewGroup) {
        e a2 = com.baidu.tieba.lego.card.b.ddz().a(this.mPageContext, this.jqA, 1);
        if (a2 == null) {
            return null;
        }
        a2.l(this.mPageId);
        return new b(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) iCardInfo, (ICardInfo) bVar);
        View view2 = bVar.getView();
        if (view2 != null && iCardInfo != null) {
            ((e) view2).aN(iCardInfo);
        }
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View getView(int i, View view, ViewGroup viewGroup, ICardInfo iCardInfo) {
        this.jqA = iCardInfo;
        return super.getView(i, view, viewGroup, iCardInfo);
    }
}
