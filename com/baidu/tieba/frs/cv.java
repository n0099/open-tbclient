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
public class cv extends bp<cw, cx> {
    private final int bhn;

    /* JADX INFO: Access modifiers changed from: protected */
    public cv(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bhn = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public cx a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.h.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bhn));
        return new cx(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cw cwVar, cx cxVar) {
        super.a(i, view, viewGroup, (ViewGroup) cwVar, (cw) cxVar);
        this.bbA.getLayoutMode().ac(this.mSkinType == 1);
        this.bbA.getLayoutMode().k(view);
        return view;
    }
}
