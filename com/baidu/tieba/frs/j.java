package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j extends d<k, l> {
    private final int csa;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.csa = (com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds100)) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public l onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.csa));
        return new l(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, l lVar) {
        super.onFillViewHolder(i, view, viewGroup, kVar, lVar);
        if (kVar.ahQ() == 6) {
            lVar.csd.setText(d.l.attention_no_post_tip);
        } else {
            lVar.csd.setText(d.l.no_data_text);
        }
        com.baidu.tbadk.core.util.aj.c(lVar.csd, d.e.cp_cont_d, 1);
        return view;
    }
}
