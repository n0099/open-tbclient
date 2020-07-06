package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class g extends com.baidu.tieba.frs.j<com.baidu.tieba.frs.m, h> {
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ba */
    public h b(ViewGroup viewGroup) {
        return new h(new View(this.mContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.m mVar, h hVar) {
        super.a(i, view, viewGroup, (ViewGroup) mVar, (com.baidu.tieba.frs.m) hVar);
        hVar.tX(mVar.getHeight());
        hVar.setBackground(mVar.bXQ());
        return view;
    }
}
