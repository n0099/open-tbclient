package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends bv<com.baidu.tbadk.core.data.c, b> {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public b b(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_big_image, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bVar);
        bVar.bon.setPadding(0, i - this.bfz == 0 ? this.beB : this.beC, 0, 0);
        this.bdK.getLayoutMode().ac(this.mSkinType == 1);
        this.bdK.getLayoutMode().x(view);
        if (!cVar.UJ && (this.bdK instanceof FrsActivity)) {
            cVar.UJ = true;
            ((FrsActivity) this.bdK).a(cVar, "show");
            ((FrsActivity) this.bdK).b(cVar, "show");
        }
        if (l.rn().rp()) {
            bVar.aMs.setVisibility(0);
            bVar.aMs.d(cVar.UI.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar.aMs.setVisibility(8);
        }
        if (l.rn().rt() && !TextUtils.isEmpty(cVar.UI.US)) {
            bVar.bop.setVisibility(0);
            bVar.bop.d(cVar.UI.US, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar.bop.setVisibility(8);
        }
        bVar.aHk.setText(cVar.UI.userName);
        bVar.boo.setText(aw.t(cVar.UH));
        if (StringUtils.isNull(cVar.UI.UQ)) {
            bVar.apm.setVisibility(8);
        } else {
            bVar.apm.setVisibility(0);
            bVar.apm.setText(cVar.UI.UQ);
        }
        return view;
    }
}
