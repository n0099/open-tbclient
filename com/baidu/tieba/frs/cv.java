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
public class cv extends bc<com.baidu.tbadk.core.data.v, cw> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cv(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public cw a(ViewGroup viewGroup) {
        return new cw(LayoutInflater.from(this.mContext).inflate(i.g.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.v vVar, cw cwVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tbadk.core.data.v) cwVar);
        this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
        this.aSJ.getLayoutMode().k(view);
        if (vVar == null) {
            return null;
        }
        cwVar.aPV.setText(vVar.getTitle());
        com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.kE(vVar.getId())) {
            com.baidu.tbadk.core.util.al.b(cwVar.aPV, i.c.cp_cont_c, 1);
        }
        if (vVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_top);
        } else {
            bitmapDrawable = vVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.al.i(cwVar.aVY, i.e.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        cwVar.aPV.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
