package com.baidu.tieba.frs.d;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.l;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends bw<com.baidu.tbadk.core.data.c, d> {
    public c(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public d b(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_normal, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) dVar);
        dVar.bsc.setPadding(0, i - this.bgj == 0 ? this.bfn : this.bfo, 0, 0);
        this.bek.getLayoutMode().ae(this.mSkinType == 1);
        this.bek.getLayoutMode().x(view);
        if (!cVar.Nc && (this.bek instanceof FrsActivity)) {
            cVar.Nc = true;
            ((FrsActivity) this.bek).a(cVar, "show");
            ((FrsActivity) this.bek).b(cVar, "show");
        }
        if (l.ob().od()) {
            dVar.aLx.setVisibility(0);
            dVar.aLx.c(cVar.Nb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.aLx.setVisibility(8);
        }
        if (l.ob().oh() && !TextUtils.isEmpty(cVar.Nb.Nk)) {
            dVar.bse.setVisibility(0);
            dVar.bse.c(cVar.Nb.Nk, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.bse.setVisibility(8);
        }
        dVar.aGp.setText(cVar.Nb.userName);
        if (StringUtils.isNull(cVar.Nb.Ni)) {
            dVar.title.setVisibility(8);
        } else {
            dVar.title.setVisibility(0);
            dVar.title.setText(cVar.Nb.Ni);
        }
        if (StringUtils.isNull(cVar.Nb.Nn)) {
            dVar.bsg.setVisibility(8);
        } else {
            dVar.bsg.setVisibility(0);
            dVar.bsg.setText(cVar.Nb.Nn);
        }
        return view;
    }
}
