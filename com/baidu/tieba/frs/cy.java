package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cy extends bi<com.baidu.tbadk.core.data.w> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cy(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_top_item, null);
        cz czVar = new cz(null);
        czVar.aDw = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_top_item);
        czVar.mTitle = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_top_title);
        inflate.setTag(czVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bi, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar) {
        BitmapDrawable bitmapDrawable;
        super.b(i, view, viewGroup, wVar);
        cz czVar = (cz) view.getTag();
        this.aDc.getLayoutMode().ab(this.mSkinType == 1);
        this.aDc.getLayoutMode().h(view);
        if (wVar == null) {
            return null;
        }
        czVar.mTitle.setText(wVar.getTitle());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m255getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.ip(wVar.getId())) {
            com.baidu.tbadk.core.util.ax.b(czVar.mTitle, com.baidu.tieba.t.listview_item_thread_read, 1);
        }
        if (wVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_top);
        } else {
            bitmapDrawable = wVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.ax.i(czVar.aDw, com.baidu.tieba.v.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        czVar.mTitle.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cz);
    }
}
