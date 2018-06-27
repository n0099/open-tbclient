package com.baidu.tieba.frs.a.a;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.h;
/* loaded from: classes3.dex */
public class b extends h<bc, c> implements com.baidu.tieba.frs.e.c {
    private com.baidu.tieba.frs.e.a drl;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.drl = new com.baidu.tieba.frs.e.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(LayoutInflater.from(this.mContext).inflate(d.i.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, c cVar) {
        BitmapDrawable bitmapDrawable;
        super.onFillViewHolder(i, view, viewGroup, bcVar, cVar);
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (bcVar == null) {
            return null;
        }
        cVar.mTitle.setText(bcVar.getTitle());
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.ua(bcVar.getId())) {
            am.c(cVar.mTitle, d.C0142d.cp_cont_c, 1);
        }
        if (bcVar.vr() == 1) {
            bitmapDrawable = (BitmapDrawable) am.getDrawable(d.f.icon_top);
        } else {
            bitmapDrawable = bcVar.vr() == 2 ? (BitmapDrawable) am.getDrawable(d.f.icon_notice) : null;
        }
        am.i(cVar.dtl, d.f.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        cVar.mTitle.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
