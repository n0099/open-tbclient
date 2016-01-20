package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class en extends bp<com.baidu.tbadk.core.data.z, eo> {
    /* JADX INFO: Access modifiers changed from: protected */
    public en(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public eo a(ViewGroup viewGroup) {
        return new eo(LayoutInflater.from(this.mContext).inflate(n.h.frs_top_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, eo eoVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) eoVar);
        this.bbA.getLayoutMode().ac(this.mSkinType == 1);
        this.bbA.getLayoutMode().k(view);
        if (zVar == null) {
            return null;
        }
        eoVar.aOn.setText(zVar.getTitle());
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.mD(zVar.getId())) {
            com.baidu.tbadk.core.util.as.b(eoVar.aOn, n.d.cp_cont_c, 1);
        }
        if (zVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_top);
        } else {
            bitmapDrawable = zVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.as.i(eoVar.bfw, n.f.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        eoVar.aOn.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
