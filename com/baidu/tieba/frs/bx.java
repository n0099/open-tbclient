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
public class bx extends bf<by, bz> {
    private final int bEc;

    public bx(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bEc = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public bz a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bEc));
        return new bz(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, bz bzVar) {
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) bzVar);
        if (byVar.acf() == 6) {
            bzVar.bSh.setText(t.j.attention_no_post_tip);
        } else {
            bzVar.bSh.setText(t.j.no_data_text);
        }
        com.baidu.tbadk.core.util.av.c(bzVar.bSh, t.d.cp_cont_d, 1);
        return view;
    }
}
