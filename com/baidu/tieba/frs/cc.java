package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cc extends bn<cd, ce> {
    private final int aXp;

    /* JADX INFO: Access modifiers changed from: protected */
    public cc(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aXp = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public ce a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.aXp));
        return new ce(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cd cdVar, ce ceVar) {
        super.a(i, view, viewGroup, (ViewGroup) cdVar, (cd) ceVar);
        this.aSm.getLayoutMode().ad(this.mSkinType == 1);
        this.aSm.getLayoutMode().k(view);
        return view;
    }
}
