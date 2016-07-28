package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cb extends bj<cc, cd> {
    private final int bsP;

    public cb(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bsP = (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst()) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public cd a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bsP));
        return new cd(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cc ccVar, cd cdVar) {
        super.a(i, view, viewGroup, (ViewGroup) ccVar, (cc) cdVar);
        if (ccVar.Xi() == 6) {
            cdVar.bHb.setText(u.j.attention_no_post_tip);
        } else {
            cdVar.bHb.setText(u.j.no_data_text);
        }
        com.baidu.tbadk.core.util.av.c(cdVar.bHb, u.d.cp_cont_d, 1);
        return view;
    }
}
