package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes5.dex */
public class g extends com.baidu.tieba.frs.h<com.baidu.tieba.frs.i, h> {
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ay */
    public h onCreateViewHolder(ViewGroup viewGroup) {
        return new h(new View(this.mContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.i iVar, h hVar) {
        super.onFillViewHolder(i, view, viewGroup, iVar, hVar);
        hVar.pI(iVar.getHeight());
        hVar.hZ(iVar.bck());
        return view;
    }
}
