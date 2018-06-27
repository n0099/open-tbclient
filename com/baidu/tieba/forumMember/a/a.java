package com.baidu.tieba.forumMember.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class a extends h<b, c> {
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.i.manito_item_header, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bVar, cVar);
        if (cVar.mSkinType != this.mSkinType) {
            am.j(cVar.getView(), d.C0142d.cp_bg_line_d);
            am.j(cVar.bjR, d.C0142d.cp_bg_line_b);
            am.c(cVar.title, d.C0142d.cp_cont_c, 1);
            am.j(cVar.cQY, d.C0142d.cp_bg_line_c);
        }
        cVar.title.setText(String.format(this.mContext.getResources().getString(d.k.forum_manito_num), Integer.valueOf(bVar.asu())));
        cVar.mSkinType = this.mSkinType;
        return view;
    }
}
