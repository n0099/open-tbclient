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
public class bc extends aq<bd, be> {
    private final int bHh;

    public bc(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bHh = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public be a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.frs_no_list_item_view, viewGroup, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.bHh));
        return new be(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bd bdVar, be beVar) {
        super.a(i, view, viewGroup, (ViewGroup) bdVar, (bd) beVar);
        if (bdVar.adx() == 6) {
            beVar.bUn.setText(r.j.attention_no_post_tip);
        } else {
            beVar.bUn.setText(r.j.no_data_text);
        }
        com.baidu.tbadk.core.util.at.c(beVar.bUn, r.d.cp_cont_d, 1);
        return view;
    }
}
