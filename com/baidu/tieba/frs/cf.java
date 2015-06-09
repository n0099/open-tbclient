package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cf extends av<com.baidu.tbadk.core.data.w, cg> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cf(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public cg a(ViewGroup viewGroup) {
        return new cg(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_top_item, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, cg cgVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) cgVar);
        this.aMl.getLayoutMode().ab(this.mSkinType == 1);
        this.aMl.getLayoutMode().j(view);
        if (wVar == null) {
            return null;
        }
        cgVar.mTitle.setText(wVar.getTitle());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.jL(wVar.getId())) {
            com.baidu.tbadk.core.util.ay.b(cgVar.mTitle, com.baidu.tieba.n.listview_item_thread_read, 1);
        }
        if (wVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_top);
        } else {
            bitmapDrawable = wVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.ay.i(cgVar.aMI, com.baidu.tieba.p.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        cgVar.mTitle.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
