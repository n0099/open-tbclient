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
    /* renamed from: aE */
    public h b(ViewGroup viewGroup) {
        return new h(new View(this.mContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.i iVar, h hVar) {
        super.a(i, view, viewGroup, (ViewGroup) iVar, (com.baidu.tieba.frs.i) hVar);
        hVar.pZ(iVar.getHeight());
        hVar.setBackground(iVar.bjD());
        return view;
    }
}
