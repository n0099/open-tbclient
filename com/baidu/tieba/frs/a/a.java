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
public class a extends bd<com.baidu.tbadk.core.data.c, b> {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public b a(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(this.mContext).inflate(i.g.frs_locality_bar_big_image, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bVar);
        bVar.baI.setPadding(0, i - this.aWC == 0 ? this.aTK : this.aTL, 0, 0);
        this.aSX.getLayoutMode().ad(this.mSkinType == 1);
        this.aSX.getLayoutMode().k(view);
        if (!cVar.Ux && (this.aSX instanceof FrsActivity)) {
            cVar.Ux = true;
            ((FrsActivity) this.aSX).a(cVar, "show");
            ((FrsActivity) this.aSX).b(cVar, "show");
        }
        if (m.rb().rd()) {
            bVar.aIT.setVisibility(0);
            bVar.aIT.d(cVar.Uw.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar.aIT.setVisibility(8);
        }
        if (m.rb().rf() && !TextUtils.isEmpty(cVar.Uw.UA)) {
            bVar.baK.setVisibility(0);
            bVar.baK.d(cVar.Uw.UA, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar.baK.setVisibility(8);
        }
        bVar.aPv.setText(cVar.Uw.userName);
        if (StringUtils.isNull(cVar.Uw.Uz)) {
            bVar.amV.setVisibility(8);
        } else {
            bVar.amV.setVisibility(0);
            bVar.amV.setText(cVar.Uw.Uz);
        }
        return view;
    }
}
