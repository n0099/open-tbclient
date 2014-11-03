package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class da extends bm<com.baidu.tbadk.core.data.q> {
    /* JADX INFO: Access modifiers changed from: protected */
    public da(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_top_item, null);
        db dbVar = new db(null);
        dbVar.aBU = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_top_item);
        dbVar.JN = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_top_title);
        inflate.setTag(dbVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.q qVar) {
        BitmapDrawable bitmapDrawable;
        super.b(i, view, viewGroup, qVar);
        db dbVar = (db) view.getTag();
        this.aBz.getLayoutMode().L(this.mSkinType == 1);
        this.aBz.getLayoutMode().h(view);
        if (qVar == null) {
            return null;
        }
        dbVar.JN.setText(qVar.getTitle());
        com.baidu.tieba.util.o wL = com.baidu.tieba.aj.wm().wL();
        if (wL != null && wL.hH(qVar.getId())) {
            com.baidu.tbadk.core.util.aw.b(dbVar.JN, com.baidu.tieba.s.listview_item_thread_read, 1);
        }
        if (qVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_top);
        } else {
            bitmapDrawable = qVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.aw.h(dbVar.aBU, com.baidu.tieba.u.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        dbVar.JN.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof db);
    }
}
