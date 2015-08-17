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
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends bc<com.baidu.tbadk.core.data.c, d> {
    public c(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(i.g.frs_locality_bar_normal, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) dVar);
        dVar.ban.setPadding(0, i - this.aWl == 0 ? this.aTw : this.aTx, 0, 0);
        this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
        this.aSJ.getLayoutMode().k(view);
        if (!cVar.Uw && (this.aSJ instanceof FrsActivity)) {
            cVar.Uw = true;
            ((FrsActivity) this.aSJ).a(cVar, "show");
            ((FrsActivity) this.aSJ).b(cVar, "show");
        }
        if (m.rd().rf()) {
            dVar.aIG.setVisibility(0);
            dVar.aIG.d(cVar.Uv.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.aIG.setVisibility(8);
        }
        if (m.rd().rh() && !TextUtils.isEmpty(cVar.Uv.Uz)) {
            dVar.bap.setVisibility(0);
            dVar.bap.d(cVar.Uv.Uz, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.bap.setVisibility(8);
        }
        dVar.aPi.setText(cVar.Uv.userName);
        if (StringUtils.isNull(cVar.Uv.Uy)) {
            dVar.anH.setVisibility(8);
        } else {
            dVar.anH.setVisibility(0);
            dVar.anH.setText(cVar.Uv.Uy);
        }
        if (StringUtils.isNull(cVar.Uv.UC)) {
            dVar.baq.setVisibility(8);
        } else {
            dVar.baq.setVisibility(0);
            dVar.baq.setText(cVar.Uv.UC);
        }
        return view;
    }
}
