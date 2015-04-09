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
public class e extends av<com.baidu.tbadk.core.data.c, f> {
    public e(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public f a(ViewGroup viewGroup) {
        return new f(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.frs_locality_bar_single_replenish, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.aNn.setPadding(0, i - this.aKN == 0 ? this.aIb : this.aIc, 0, 0);
        this.aKd.getLayoutMode().X(this.mSkinType == 1);
        this.aKd.getLayoutMode().h(view);
        if (!cVar.Pn) {
            cVar.Pn = true;
            this.aKd.a(cVar, "show");
            this.aKd.b(cVar, "show");
        }
        if (n.px().pz()) {
            fVar.azz.setVisibility(0);
            fVar.azz.c(cVar.Pm.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.azz.setVisibility(8);
        }
        if (n.px().pB() && !TextUtils.isEmpty(cVar.Pm.Pq)) {
            fVar.aNp.setVisibility(0);
            fVar.aNp.c(cVar.Pm.Pq, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.aNp.setVisibility(8);
        }
        fVar.aFA.setText(cVar.Pm.userName);
        if (StringUtils.isNull(cVar.Pm.Pp)) {
            fVar.ahz.setVisibility(8);
        } else {
            fVar.ahz.setVisibility(0);
            fVar.ahz.setText(cVar.Pm.Pp);
        }
        if (StringUtils.isNull(cVar.Pm.Pt)) {
            fVar.aNq.setVisibility(8);
        } else {
            fVar.aNq.setVisibility(0);
            fVar.aNq.setText(cVar.Pm.Pt);
        }
        if (StringUtils.isNull(cVar.Pm.Pu)) {
            fVar.aNr.setVisibility(8);
        } else {
            fVar.aNr.setVisibility(0);
            fVar.aNr.setText(cVar.Pm.Pu);
        }
        return view;
    }
}
