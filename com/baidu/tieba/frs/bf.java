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
public class bf extends av<bg, bh> {
    private final int bOP;

    public bf(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bOP = (com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public bh onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bOP));
        return new bh(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, bh bhVar) {
        super.onFillViewHolder(i, view, viewGroup, bgVar, bhVar);
        if (bgVar.aau() == 6) {
            bhVar.bOS.setText(w.l.attention_no_post_tip);
        } else {
            bhVar.bOS.setText(w.l.no_data_text);
        }
        com.baidu.tbadk.core.util.aq.c(bhVar.bOS, w.e.cp_cont_d, 1);
        return view;
    }
}
