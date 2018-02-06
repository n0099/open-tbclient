package com.baidu.tieba.frs.a.a;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g;
/* loaded from: classes3.dex */
public class b extends g<bd, c> implements com.baidu.tieba.frs.e.c {
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aD */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.h.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, c cVar) {
        BitmapDrawable bitmapDrawable;
        super.onFillViewHolder(i, view, viewGroup, bdVar, cVar);
        this.mPageContext.getLayoutMode().aQ(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().aM(view);
        if (bdVar == null) {
            return null;
        }
        cVar.mTitle.setText(bdVar.getTitle());
        com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.sW(bdVar.getId())) {
            aj.e(cVar.mTitle, d.C0140d.cp_cont_c, 1);
        }
        if (bdVar.zi() == 1) {
            bitmapDrawable = (BitmapDrawable) aj.getDrawable(d.f.icon_top);
        } else {
            bitmapDrawable = bdVar.zi() == 2 ? (BitmapDrawable) aj.getDrawable(d.f.icon_notice) : null;
        }
        aj.s(cVar.dNj, d.f.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        cVar.mTitle.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
