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
public class a extends av<com.baidu.tbadk.core.data.c, b> {
    public a(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public b a(ViewGroup viewGroup) {
        return new b(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.frs_locality_bar_big_image, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bVar);
        bVar.aNn.setPadding(0, i - this.aKN == 0 ? this.aIb : this.aIc, 0, 0);
        this.aKd.getLayoutMode().X(this.mSkinType == 1);
        this.aKd.getLayoutMode().h(view);
        if (!cVar.Pn) {
            cVar.Pn = true;
            this.aKd.a(cVar, "show");
            this.aKd.b(cVar, "show");
        }
        if (n.px().pz()) {
            bVar.azz.setVisibility(0);
            bVar.azz.c(cVar.Pm.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar.azz.setVisibility(8);
        }
        if (n.px().pB() && !TextUtils.isEmpty(cVar.Pm.Pq)) {
            bVar.aNp.setVisibility(0);
            bVar.aNp.c(cVar.Pm.Pq, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar.aNp.setVisibility(8);
        }
        bVar.aFA.setText(cVar.Pm.userName);
        if (StringUtils.isNull(cVar.Pm.Pp)) {
            bVar.ahz.setVisibility(8);
        } else {
            bVar.ahz.setVisibility(0);
            bVar.ahz.setText(cVar.Pm.Pp);
        }
        return view;
    }
}
