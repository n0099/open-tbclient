package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cg extends av<com.baidu.tbadk.core.data.w, ch> {
    /* JADX INFO: Access modifiers changed from: protected */
    public cg(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public ch a(ViewGroup viewGroup) {
        return new ch(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_top_item, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.w wVar, ch chVar) {
        BitmapDrawable bitmapDrawable;
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tbadk.core.data.w) chVar);
        this.aJT.getLayoutMode().X(this.mSkinType == 1);
        this.aJT.getLayoutMode().h(view);
        if (wVar == null) {
            return null;
        }
        chVar.mTitle.setText(wVar.getTitle());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.iO(wVar.getId())) {
            com.baidu.tbadk.core.util.ba.b(chVar.mTitle, com.baidu.tieba.s.listview_item_thread_read, 1);
        }
        if (wVar.getIs_top() == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_top);
        } else {
            bitmapDrawable = wVar.getIs_top() == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_notice) : null;
        }
        com.baidu.tbadk.core.util.ba.i(chVar.aKq, com.baidu.tieba.u.frs_top_item_bg);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        chVar.mTitle.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }
}
