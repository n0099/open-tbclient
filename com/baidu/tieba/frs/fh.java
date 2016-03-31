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
public class fh extends bx<com.baidu.tbadk.core.data.as, fi> {
    /* JADX INFO: Access modifiers changed from: protected */
    public fh(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public fi b(ViewGroup viewGroup) {
        return new fi(LayoutInflater.from(this.mContext).inflate(t.h.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, fi fiVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) fiVar);
        this.bix.getLayoutMode().ab(this.mSkinType == 1);
        this.bix.getLayoutMode().x(view);
        if (asVar == null) {
            return null;
        }
        fiVar.aSh.setText(asVar.getTitle());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
            com.baidu.tbadk.core.util.at.b(fiVar.aSh, t.d.cp_cont_c, 1);
        }
        if (asVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_top);
        } else {
            bitmapDrawable = asVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.at.k(fiVar.bmO, t.f.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        fiVar.aSh.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
