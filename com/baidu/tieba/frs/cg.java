package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cg extends bd<com.baidu.tbadk.core.data.p, cl> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public cg(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public cl a(ViewGroup viewGroup) {
        return new cl(LayoutInflater.from(this.mContext).inflate(i.g.frs_photo_live_view_pager_div, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.p pVar, cl clVar) {
        super.a(i, view, viewGroup, (ViewGroup) pVar, (com.baidu.tbadk.core.data.p) clVar);
        clVar.aYr.a(pVar);
        clVar.aYq.setTag(pVar);
        clVar.aYq.setOnClickListener(this);
        com.baidu.tbadk.h.a.a(this.aSX.getPageContext(), view);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id;
        if ((view.getTag() instanceof com.baidu.tbadk.core.data.p) && (id = view.getId()) == i.f.all_live_list) {
            this.aWB.a(id, 0, view, null, (com.baidu.tbadk.core.data.p) view.getTag());
        }
    }

    public int Mn() {
        return i.f.all_live_list;
    }
}
