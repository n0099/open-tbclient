package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class du extends bn<com.baidu.tbadk.core.data.w, dv> {
    /* JADX INFO: Access modifiers changed from: protected */
    public du(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public dv a(ViewGroup viewGroup) {
        return new dv(LayoutInflater.from(this.mContext).inflate(i.g.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, dv dvVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) dvVar);
        this.aSe.getLayoutMode().ad(this.mSkinType == 1);
        this.aSe.getLayoutMode().k(view);
        if (wVar == null) {
            return null;
        }
        dvVar.aPq.setText(wVar.getTitle());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.lL(wVar.getId())) {
            com.baidu.tbadk.core.util.an.b(dvVar.aPq, i.c.cp_cont_c, 1);
        }
        if (wVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_top);
        } else {
            bitmapDrawable = wVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.an.i(dvVar.aVZ, i.e.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        dvVar.aPq.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
