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
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends bd<com.baidu.tbadk.core.data.c, f> {
    public e(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public f a(ViewGroup viewGroup) {
        return new f(LayoutInflater.from(this.mContext).inflate(i.g.frs_locality_bar_single_replenish, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.baI.setPadding(0, i - this.aWC == 0 ? this.aTK : this.aTL, 0, 0);
        this.aSX.getLayoutMode().ad(this.mSkinType == 1);
        this.aSX.getLayoutMode().k(view);
        if (!cVar.Ux && (this.aSX instanceof FrsActivity)) {
            cVar.Ux = true;
            ((FrsActivity) this.aSX).a(cVar, "show");
            ((FrsActivity) this.aSX).b(cVar, "show");
        }
        if (m.rb().rd()) {
            fVar.aIT.setVisibility(0);
            fVar.aIT.d(cVar.Uw.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aIT.setVisibility(8);
        }
        if (m.rb().rf() && !TextUtils.isEmpty(cVar.Uw.UA)) {
            fVar.baK.setVisibility(0);
            fVar.baK.d(cVar.Uw.UA, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.baK.setVisibility(8);
        }
        fVar.aPv.setText(cVar.Uw.userName);
        if (StringUtils.isNull(cVar.Uw.Uz)) {
            fVar.amV.setVisibility(8);
        } else {
            fVar.amV.setVisibility(0);
            fVar.amV.setText(cVar.Uw.Uz);
        }
        if (StringUtils.isNull(cVar.Uw.UD)) {
            fVar.baL.setVisibility(8);
        } else {
            fVar.baL.setVisibility(0);
            fVar.baL.setText(cVar.Uw.UD);
        }
        if (StringUtils.isNull(cVar.Uw.UE)) {
            fVar.baM.setVisibility(8);
        } else {
            fVar.baM.setVisibility(0);
            fVar.baM.setText(cVar.Uw.UE);
        }
        return view;
    }
}
