package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bf extends au<bg, bh> {
    private final int bAw;

    public bf(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bAw = (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: p */
    public bh a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bAw));
        return new bh(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.au, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, bh bhVar) {
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) bhVar);
        if (bgVar.XQ() == 6) {
            bhVar.bAz.setText(r.j.attention_no_post_tip);
        } else {
            bhVar.bAz.setText(r.j.no_data_text);
        }
        com.baidu.tbadk.core.util.ar.c(bhVar.bAz, r.d.cp_cont_d, 1);
        return view;
    }
}
