package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ba extends p<bb, bc> {
    private final int bVO;

    public ba(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bVO = (com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public bc onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bVO));
        return new bc(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, bc bcVar) {
        super.onFillViewHolder(i, view, viewGroup, bbVar, bcVar);
        if (bbVar.aaZ() == 6) {
            bcVar.bVR.setText(w.l.attention_no_post_tip);
        } else {
            bcVar.bVR.setText(w.l.no_data_text);
        }
        com.baidu.tbadk.core.util.aq.c(bcVar.bVR, w.e.cp_cont_d, 1);
        return view;
    }
}
