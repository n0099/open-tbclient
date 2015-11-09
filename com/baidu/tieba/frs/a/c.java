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
import com.baidu.tieba.frs.bn;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends bn<com.baidu.tbadk.core.data.b, d> {
    public c(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(i.g.frs_locality_bar_normal, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bn, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) dVar);
        dVar.bbf.setPadding(0, i - this.aTY == 0 ? this.aSZ : this.aTa, 0, 0);
        this.aSm.getLayoutMode().ad(this.mSkinType == 1);
        this.aSm.getLayoutMode().k(view);
        if (!bVar.Ul && (this.aSm instanceof FrsActivity)) {
            bVar.Ul = true;
            ((FrsActivity) this.aSm).a(bVar, "show");
            ((FrsActivity) this.aSm).b(bVar, "show");
        }
        if (m.qV().qX()) {
            dVar.aGQ.setVisibility(0);
            dVar.aGQ.d(bVar.Uk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.aGQ.setVisibility(8);
        }
        if (m.qV().qZ() && !TextUtils.isEmpty(bVar.Uk.Up)) {
            dVar.bbh.setVisibility(0);
            dVar.bbh.d(bVar.Uk.Up, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.bbh.setVisibility(8);
        }
        dVar.aCf.setText(bVar.Uk.userName);
        if (StringUtils.isNull(bVar.Uk.Un)) {
            dVar.alz.setVisibility(8);
        } else {
            dVar.alz.setVisibility(0);
            dVar.alz.setText(bVar.Uk.Un);
        }
        if (StringUtils.isNull(bVar.Uk.Us)) {
            dVar.bbi.setVisibility(8);
        } else {
            dVar.bbi.setVisibility(0);
            dVar.bbi.setText(bVar.Uk.Us);
        }
        return view;
    }
}
