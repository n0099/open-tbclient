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
public class az extends p<ba, bb> {
    private final int bPX;

    public az(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bPX = (com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public bb onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bPX));
        return new bb(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ba baVar, bb bbVar) {
        super.onFillViewHolder(i, view, viewGroup, baVar, bbVar);
        if (baVar.ZX() == 6) {
            bbVar.bQa.setText(w.l.attention_no_post_tip);
        } else {
            bbVar.bQa.setText(w.l.no_data_text);
        }
        com.baidu.tbadk.core.util.aq.c(bbVar.bQa, w.e.cp_cont_d, 1);
        return view;
    }
}
