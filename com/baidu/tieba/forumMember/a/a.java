package com.baidu.tieba.forumMember.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.frs.f<b, c> {
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.i.manito_item_header, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, b bVar, c cVar) {
        super.onFillViewHolder(i, view2, viewGroup, bVar, cVar);
        if (cVar.mSkinType != this.mSkinType) {
            ak.j(cVar.getView(), d.C0126d.cp_bg_line_d);
            ak.j(cVar.bae, d.C0126d.cp_bg_line_b);
            ak.c(cVar.title, d.C0126d.cp_cont_c, 1);
            ak.j(cVar.cIL, d.C0126d.cp_bg_line_c);
        }
        cVar.title.setText(String.format(this.mContext.getResources().getString(d.k.forum_manito_num), Integer.valueOf(bVar.aof())));
        cVar.mSkinType = this.mSkinType;
        return view2;
    }
}
