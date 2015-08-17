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
public class e extends bc<com.baidu.tbadk.core.data.c, f> {
    public e(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public f a(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(i.g.frs_locality_bar_single_replenish, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.ban.setPadding(0, i - this.aWl == 0 ? this.aTw : this.aTx, 0, 0);
        this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
        this.aSJ.getLayoutMode().k(view);
        if (!cVar.Uw && (this.aSJ instanceof FrsActivity)) {
            cVar.Uw = true;
            ((FrsActivity) this.aSJ).a(cVar, "show");
            ((FrsActivity) this.aSJ).b(cVar, "show");
        }
        if (m.rd().rf()) {
            fVar.aIG.setVisibility(0);
            fVar.aIG.d(cVar.Uv.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aIG.setVisibility(8);
        }
        if (m.rd().rh() && !TextUtils.isEmpty(cVar.Uv.Uz)) {
            fVar.bap.setVisibility(0);
            fVar.bap.d(cVar.Uv.Uz, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.bap.setVisibility(8);
        }
        fVar.aPi.setText(cVar.Uv.userName);
        if (StringUtils.isNull(cVar.Uv.Uy)) {
            fVar.anH.setVisibility(8);
        } else {
            fVar.anH.setVisibility(0);
            fVar.anH.setText(cVar.Uv.Uy);
        }
        if (StringUtils.isNull(cVar.Uv.UC)) {
            fVar.baq.setVisibility(8);
        } else {
            fVar.baq.setVisibility(0);
            fVar.baq.setText(cVar.Uv.UC);
        }
        if (StringUtils.isNull(cVar.Uv.UD)) {
            fVar.bas.setVisibility(8);
        } else {
            fVar.bas.setVisibility(0);
            fVar.bas.setText(cVar.Uv.UD);
        }
        return view;
    }
}
