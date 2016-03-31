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
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends bx<com.baidu.tbadk.core.data.c, f> {
    public e(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public f b(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_single_replenish, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.btm.setPadding(0, i - this.bkj == 0 ? this.bjn : this.bjo, 0, 0);
        this.bix.getLayoutMode().ab(this.mSkinType == 1);
        this.bix.getLayoutMode().x(view);
        if (!cVar.So && (this.bix instanceof FrsActivity)) {
            cVar.So = true;
            ((FrsActivity) this.bix).a(cVar, "show");
            ((FrsActivity) this.bix).b(cVar, "show");
        }
        if (l.qE().qG()) {
            fVar.aPn.setVisibility(0);
            fVar.aPn.c(cVar.Sn.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aPn.setVisibility(8);
        }
        if (l.qE().qK() && !TextUtils.isEmpty(cVar.Sn.Sw)) {
            fVar.bto.setVisibility(0);
            fVar.bto.c(cVar.Sn.Sw, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.bto.setVisibility(8);
        }
        fVar.aKg.setText(cVar.Sn.userName);
        if (StringUtils.isNull(cVar.Sn.Su)) {
            fVar.apE.setVisibility(8);
        } else {
            fVar.apE.setVisibility(0);
            fVar.apE.setText(cVar.Sn.Su);
        }
        if (StringUtils.isNull(cVar.Sn.Sz)) {
            fVar.btq.setVisibility(8);
        } else {
            fVar.btq.setVisibility(0);
            fVar.btq.setText(cVar.Sn.Sz);
        }
        if (StringUtils.isNull(cVar.Sn.SA)) {
            fVar.btr.setVisibility(8);
        } else {
            fVar.btr.setVisibility(0);
            fVar.btr.setText(cVar.Sn.SA);
        }
        return view;
    }
}
