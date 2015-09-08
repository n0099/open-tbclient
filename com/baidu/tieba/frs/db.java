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
public class db extends bd<com.baidu.tbadk.core.data.x, dc> {
    /* JADX INFO: Access modifiers changed from: protected */
    public db(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public dc a(ViewGroup viewGroup) {
        return new dc(LayoutInflater.from(this.mContext).inflate(i.g.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.x xVar, dc dcVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) xVar, (com.baidu.tbadk.core.data.x) dcVar);
        this.aSX.getLayoutMode().ad(this.mSkinType == 1);
        this.aSX.getLayoutMode().k(view);
        if (xVar == null) {
            return null;
        }
        dcVar.aQj.setText(xVar.getTitle());
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.lj(xVar.getId())) {
            com.baidu.tbadk.core.util.al.b(dcVar.aQj, i.c.cp_cont_c, 1);
        }
        if (xVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_top);
        } else {
            bitmapDrawable = xVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.al.h(dcVar.aWp, i.e.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        dcVar.aQj.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
