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
public class e extends bw<com.baidu.tbadk.core.data.c, f> {
    public e(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public f b(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(t.h.frs_locality_bar_single_replenish, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.bsc.setPadding(0, i - this.bgj == 0 ? this.bfn : this.bfo, 0, 0);
        this.bek.getLayoutMode().ae(this.mSkinType == 1);
        this.bek.getLayoutMode().x(view);
        if (!cVar.Nc && (this.bek instanceof FrsActivity)) {
            cVar.Nc = true;
            ((FrsActivity) this.bek).a(cVar, "show");
            ((FrsActivity) this.bek).b(cVar, "show");
        }
        if (l.ob().od()) {
            fVar.aLx.setVisibility(0);
            fVar.aLx.c(cVar.Nb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aLx.setVisibility(8);
        }
        if (l.ob().oh() && !TextUtils.isEmpty(cVar.Nb.Nk)) {
            fVar.bse.setVisibility(0);
            fVar.bse.c(cVar.Nb.Nk, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.bse.setVisibility(8);
        }
        fVar.aGp.setText(cVar.Nb.userName);
        if (StringUtils.isNull(cVar.Nb.Ni)) {
            fVar.title.setVisibility(8);
        } else {
            fVar.title.setVisibility(0);
            fVar.title.setText(cVar.Nb.Ni);
        }
        if (StringUtils.isNull(cVar.Nb.Nn)) {
            fVar.bsg.setVisibility(8);
        } else {
            fVar.bsg.setVisibility(0);
            fVar.bsg.setText(cVar.Nb.Nn);
        }
        if (StringUtils.isNull(cVar.Nb.No)) {
            fVar.bsh.setVisibility(8);
        } else {
            fVar.bsh.setVisibility(0);
            fVar.bsh.setText(cVar.Nb.No);
        }
        return view;
    }
}
