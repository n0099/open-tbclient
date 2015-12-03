package com.baidu.tieba.frs.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.m;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends bm<com.baidu.tbadk.core.data.b, d> {
    public c(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: D */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(n.g.frs_locality_bar_normal, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) dVar);
        dVar.bhH.setPadding(0, i - this.aZm == 0 ? this.aYn : this.aYo, 0, 0);
        this.aXA.getLayoutMode().af(this.mSkinType == 1);
        this.aXA.getLayoutMode().k(view);
        if (!bVar.UB && (this.aXA instanceof FrsActivity)) {
            bVar.UB = true;
            ((FrsActivity) this.aXA).a(bVar, "show");
            ((FrsActivity) this.aXA).b(bVar, "show");
        }
        if (m.rh().rj()) {
            dVar.aJP.setVisibility(0);
            dVar.aJP.d(bVar.UA.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.aJP.setVisibility(8);
        }
        if (m.rh().rn() && !TextUtils.isEmpty(bVar.UA.UF)) {
            dVar.bhJ.setVisibility(0);
            dVar.bhJ.d(bVar.UA.UF, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.bhJ.setVisibility(8);
        }
        dVar.aER.setText(bVar.UA.userName);
        if (StringUtils.isNull(bVar.UA.UD)) {
            dVar.agd.setVisibility(8);
        } else {
            dVar.agd.setVisibility(0);
            dVar.agd.setText(bVar.UA.UD);
        }
        if (StringUtils.isNull(bVar.UA.UI)) {
            dVar.bhL.setVisibility(8);
        } else {
            dVar.bhL.setVisibility(0);
            dVar.bhL.setText(bVar.UA.UI);
        }
        return view;
    }
}
