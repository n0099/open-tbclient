package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cq extends bn<com.baidu.tbadk.core.data.o, cv> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public cq(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public cv a(ViewGroup viewGroup) {
        return new cv(LayoutInflater.from(this.mContext).inflate(i.g.frs_photo_live_view_pager_div, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.o oVar, cv cvVar) {
        super.a(i, view, viewGroup, (ViewGroup) oVar, (com.baidu.tbadk.core.data.o) cvVar);
        cvVar.aXL.a(oVar);
        cvVar.aXK.setTag(oVar);
        cvVar.aXK.setOnClickListener(this);
        com.baidu.tbadk.h.a.a(this.aRT.getPageContext(), view);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id;
        if ((view.getTag() instanceof com.baidu.tbadk.core.data.o) && (id = view.getId()) == i.f.all_live_list) {
            this.aVV.a(id, 0, view, null, (com.baidu.tbadk.core.data.o) view.getTag());
        }
    }

    public int Mm() {
        return i.f.all_live_list;
    }
}
