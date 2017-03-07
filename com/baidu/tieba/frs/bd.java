package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class bd extends at<be, bf> {
    private final int bPa;

    public bd(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bPa = (com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public bf onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bPa));
        return new bf(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, be beVar, bf bfVar) {
        super.onFillViewHolder(i, view, viewGroup, beVar, bfVar);
        if (beVar.ZW() == 6) {
            bfVar.bPd.setText(w.l.attention_no_post_tip);
        } else {
            bfVar.bPd.setText(w.l.no_data_text);
        }
        com.baidu.tbadk.core.util.aq.c(bfVar.bPd, w.e.cp_cont_d, 1);
        return view;
    }
}
