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
public class du extends bn<com.baidu.tbadk.core.data.v, dv> {
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, dv dvVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) dvVar);
        this.aRT.getLayoutMode().ad(this.mSkinType == 1);
        this.aRT.getLayoutMode().k(view);
        if (vVar == null) {
            return null;
        }
        dvVar.aPf.setText(vVar.getTitle());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.lI(vVar.getId())) {
            com.baidu.tbadk.core.util.am.b(dvVar.aPf, i.c.cp_cont_c, 1);
        }
        if (vVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_top);
        } else {
            bitmapDrawable = vVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.am.i(dvVar.aVO, i.e.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        dvVar.aPf.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
