package com.baidu.tieba.forumMember.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g;
/* loaded from: classes3.dex */
public class a extends g<b, c> {
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.h.manito_item_header, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bVar, cVar);
        if (cVar.mSkinType != this.mSkinType) {
            aj.t(cVar.getView(), d.C0140d.cp_bg_line_d);
            aj.t(cVar.bQs, d.C0140d.cp_bg_line_b);
            aj.e(cVar.title, d.C0140d.cp_cont_c, 1);
            aj.t(cVar.dqv, d.C0140d.cp_bg_line_c);
        }
        cVar.title.setText(String.format(this.mContext.getResources().getString(d.j.forum_manito_num), Integer.valueOf(bVar.atQ())));
        cVar.mSkinType = this.mSkinType;
        return view;
    }
}
