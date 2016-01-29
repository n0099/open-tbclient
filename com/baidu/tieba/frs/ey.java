package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ey extends bv<com.baidu.tbadk.core.data.ah, ez> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ey(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: F */
    public ez b(ViewGroup viewGroup) {
        return new ez(LayoutInflater.from(this.mContext).inflate(t.h.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, ez ezVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) ahVar, (com.baidu.tbadk.core.data.ah) ezVar);
        this.bdK.getLayoutMode().ac(this.mSkinType == 1);
        this.bdK.getLayoutMode().x(view);
        if (ahVar == null) {
            return null;
        }
        ezVar.aPr.setText(ahVar.getTitle());
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
            com.baidu.tbadk.core.util.ar.b(ezVar.aPr, t.d.cp_cont_c, 1);
        }
        if (ahVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_top);
        } else {
            bitmapDrawable = ahVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.ar.k(ezVar.bib, t.f.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        ezVar.aPr.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
