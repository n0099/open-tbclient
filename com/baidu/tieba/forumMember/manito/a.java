package com.baidu.tieba.forumMember.manito;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.k;
/* loaded from: classes8.dex */
public class a extends k<b, ManitoHeaderItemViewHolder> {
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public ManitoHeaderItemViewHolder e(ViewGroup viewGroup) {
        return new ManitoHeaderItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.manito_item_header, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, b bVar, ManitoHeaderItemViewHolder manitoHeaderItemViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (b) manitoHeaderItemViewHolder);
        if (manitoHeaderItemViewHolder.mSkinType != this.mSkinType) {
            ap.setBackgroundColor(manitoHeaderItemViewHolder.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(manitoHeaderItemViewHolder.title, R.color.CAM_X0105, 1);
        }
        manitoHeaderItemViewHolder.title.setText(String.format(this.mContext.getResources().getString(R.string.forum_manito_num), Integer.valueOf(bVar.cAJ())));
        manitoHeaderItemViewHolder.mSkinType = this.mSkinType;
        return view;
    }
}
