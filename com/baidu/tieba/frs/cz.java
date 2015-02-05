package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cz extends bh<com.baidu.tbadk.core.data.x> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cz(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_top_item, null);
        da daVar = new da(null);
        daVar.aEu = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_top_item);
        daVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_top_title);
        inflate.setTag(daVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.x xVar) {
        BitmapDrawable bitmapDrawable;
        super.b(i, view, viewGroup, xVar);
        da daVar = (da) view.getTag();
        this.aEa.getLayoutMode().ab(this.mSkinType == 1);
        this.aEa.getLayoutMode().h(view);
        if (xVar == null) {
            return null;
        }
        daVar.mTitle.setText(xVar.getTitle());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.iu(xVar.getId())) {
            com.baidu.tbadk.core.util.bc.b(daVar.mTitle, com.baidu.tieba.t.listview_item_thread_read, 1);
        }
        if (xVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_top);
        } else {
            bitmapDrawable = xVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.bc.i(daVar.aEu, com.baidu.tieba.v.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        daVar.mTitle.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof da);
    }
}
