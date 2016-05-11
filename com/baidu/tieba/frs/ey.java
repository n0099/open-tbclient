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
public class ey extends bw<com.baidu.tbadk.core.data.ax, ez> {
    public ey(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public ez b(ViewGroup viewGroup) {
        return new ez(LayoutInflater.from(this.mContext).inflate(t.h.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, ez ezVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) ezVar);
        this.bek.getLayoutMode().ae(this.mSkinType == 1);
        this.bek.getLayoutMode().x(view);
        if (axVar == null) {
            return null;
        }
        ezVar.aOG.setText(axVar.getTitle());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
            com.baidu.tbadk.core.util.at.c(ezVar.aOG, t.d.cp_cont_c, 1);
        }
        if (axVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_top);
        } else {
            bitmapDrawable = axVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.at.k(ezVar.bin, t.f.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        ezVar.aOG.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
