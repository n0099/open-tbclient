package com.baidu.tieba.frs.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends av<com.baidu.tbadk.core.data.c, d> {
    public c(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public d a(ViewGroup viewGroup) {
        return new d(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.frs_locality_bar_normal, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) dVar);
        dVar.aNn.setPadding(0, i - this.aKN == 0 ? this.aIb : this.aIc, 0, 0);
        this.aKd.getLayoutMode().X(this.mSkinType == 1);
        this.aKd.getLayoutMode().h(view);
        if (!cVar.Pn) {
            cVar.Pn = true;
            this.aKd.a(cVar, "show");
            this.aKd.b(cVar, "show");
        }
        if (n.px().pz()) {
            dVar.azz.setVisibility(0);
            dVar.azz.c(cVar.Pm.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.azz.setVisibility(8);
        }
        if (n.px().pB() && !TextUtils.isEmpty(cVar.Pm.Pq)) {
            dVar.aNp.setVisibility(0);
            dVar.aNp.c(cVar.Pm.Pq, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.aNp.setVisibility(8);
        }
        dVar.aFA.setText(cVar.Pm.userName);
        if (StringUtils.isNull(cVar.Pm.Pp)) {
            dVar.ahz.setVisibility(8);
        } else {
            dVar.ahz.setVisibility(0);
            dVar.ahz.setText(cVar.Pm.Pp);
        }
        if (StringUtils.isNull(cVar.Pm.Pt)) {
            dVar.aNq.setVisibility(8);
        } else {
            dVar.aNq.setVisibility(0);
            dVar.aNq.setText(cVar.Pm.Pt);
        }
        return view;
    }
}
