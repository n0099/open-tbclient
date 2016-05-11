package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dc extends bw<dd, de> {
    private final int bkC;

    public dc(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkC = (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public de b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bkC));
        return new de(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, dd ddVar, de deVar) {
        super.a(i, view, viewGroup, (ViewGroup) ddVar, (dd) deVar);
        this.bek.getLayoutMode().ae(this.mSkinType == 1);
        this.bek.getLayoutMode().x(view);
        return view;
    }
}
