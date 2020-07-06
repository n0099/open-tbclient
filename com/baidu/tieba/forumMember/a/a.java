package com.baidu.tieba.forumMember.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.j;
/* loaded from: classes10.dex */
public class a extends j<b, c> {
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public c b(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(R.layout.manito_item_header, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) cVar);
        if (cVar.mSkinType != this.mSkinType) {
            an.setBackgroundColor(cVar.getView(), R.color.cp_bg_line_d);
            an.setViewTextColor(cVar.title, R.color.cp_cont_b, 1);
        }
        cVar.title.setText(String.format(this.mContext.getResources().getString(R.string.forum_manito_num), Integer.valueOf(bVar.bWu())));
        cVar.mSkinType = this.mSkinType;
        return view;
    }
}
