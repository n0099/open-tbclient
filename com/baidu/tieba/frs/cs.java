package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cs extends bm<ct, cu> {
    private final int bdn;

    /* JADX INFO: Access modifiers changed from: protected */
    public cs(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bdn = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public cu a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.g.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bdn));
        return new cu(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ct ctVar, cu cuVar) {
        super.a(i, view, viewGroup, (ViewGroup) ctVar, (ct) cuVar);
        this.aXA.getLayoutMode().af(this.mSkinType == 1);
        this.aXA.getLayoutMode().k(view);
        return view;
    }
}
