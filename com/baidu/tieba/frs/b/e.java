package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.l;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends bv<com.baidu.tbadk.core.data.c, f> {
    public e(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public f b(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_single_replenish, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.bon.setPadding(0, i - this.bfz == 0 ? this.beB : this.beC, 0, 0);
        this.bdK.getLayoutMode().ac(this.mSkinType == 1);
        this.bdK.getLayoutMode().x(view);
        if (!cVar.UJ && (this.bdK instanceof FrsActivity)) {
            cVar.UJ = true;
            ((FrsActivity) this.bdK).a(cVar, "show");
            ((FrsActivity) this.bdK).b(cVar, "show");
        }
        if (l.rn().rp()) {
            fVar.aMs.setVisibility(0);
            fVar.aMs.d(cVar.UI.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aMs.setVisibility(8);
        }
        if (l.rn().rt() && !TextUtils.isEmpty(cVar.UI.US)) {
            fVar.bop.setVisibility(0);
            fVar.bop.d(cVar.UI.US, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.bop.setVisibility(8);
        }
        fVar.aHk.setText(cVar.UI.userName);
        if (StringUtils.isNull(cVar.UI.UQ)) {
            fVar.apm.setVisibility(8);
        } else {
            fVar.apm.setVisibility(0);
            fVar.apm.setText(cVar.UI.UQ);
        }
        if (StringUtils.isNull(cVar.UI.UV)) {
            fVar.bor.setVisibility(8);
        } else {
            fVar.bor.setVisibility(0);
            fVar.bor.setText(cVar.UI.UV);
        }
        if (StringUtils.isNull(cVar.UI.UW)) {
            fVar.bos.setVisibility(8);
        } else {
            fVar.bos.setVisibility(0);
            fVar.bos.setText(cVar.UI.UW);
        }
        return view;
    }
}
