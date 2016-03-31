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
public class c extends bx<com.baidu.tbadk.core.data.c, d> {
    public c(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: M */
    public d b(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_normal, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) dVar);
        dVar.btm.setPadding(0, i - this.bkj == 0 ? this.bjn : this.bjo, 0, 0);
        this.bix.getLayoutMode().ab(this.mSkinType == 1);
        this.bix.getLayoutMode().x(view);
        if (!cVar.So && (this.bix instanceof FrsActivity)) {
            cVar.So = true;
            ((FrsActivity) this.bix).a(cVar, "show");
            ((FrsActivity) this.bix).b(cVar, "show");
        }
        if (l.qE().qG()) {
            dVar.aPn.setVisibility(0);
            dVar.aPn.c(cVar.Sn.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.aPn.setVisibility(8);
        }
        if (l.qE().qK() && !TextUtils.isEmpty(cVar.Sn.Sw)) {
            dVar.bto.setVisibility(0);
            dVar.bto.c(cVar.Sn.Sw, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.bto.setVisibility(8);
        }
        dVar.aKg.setText(cVar.Sn.userName);
        if (StringUtils.isNull(cVar.Sn.Su)) {
            dVar.apE.setVisibility(8);
        } else {
            dVar.apE.setVisibility(0);
            dVar.apE.setText(cVar.Sn.Su);
        }
        if (StringUtils.isNull(cVar.Sn.Sz)) {
            dVar.btq.setVisibility(8);
        } else {
            dVar.btq.setVisibility(0);
            dVar.btq.setText(cVar.Sn.Sz);
        }
        return view;
    }
}
