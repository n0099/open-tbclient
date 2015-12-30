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
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends bp<com.baidu.tbadk.core.data.b, d> {
    public c(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public d a(ViewGroup viewGroup) {
        return new d(LayoutInflater.from(this.mContext).inflate(n.h.frs_locality_bar_normal, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.b bVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) bVar, (com.baidu.tbadk.core.data.b) dVar);
        dVar.bly.setPadding(0, i - this.bdi == 0 ? this.bcm : this.bcn, 0, 0);
        this.bbA.getLayoutMode().ac(this.mSkinType == 1);
        this.bbA.getLayoutMode().k(view);
        if (!bVar.Vc && (this.bbA instanceof FrsActivity)) {
            bVar.Vc = true;
            ((FrsActivity) this.bbA).a(bVar, "show");
            ((FrsActivity) this.bbA).b(bVar, "show");
        }
        if (m.qQ().qS()) {
            dVar.aLn.setVisibility(0);
            dVar.aLn.d(bVar.Vb.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.aLn.setVisibility(8);
        }
        if (m.qQ().qW() && !TextUtils.isEmpty(bVar.Vb.Vg)) {
            dVar.blA.setVisibility(0);
            dVar.blA.d(bVar.Vb.Vg, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.blA.setVisibility(8);
        }
        dVar.aGr.setText(bVar.Vb.userName);
        if (StringUtils.isNull(bVar.Vb.Ve)) {
            dVar.ahk.setVisibility(8);
        } else {
            dVar.ahk.setVisibility(0);
            dVar.ahk.setText(bVar.Vb.Ve);
        }
        if (StringUtils.isNull(bVar.Vb.Vj)) {
            dVar.blC.setVisibility(8);
        } else {
            dVar.blC.setVisibility(0);
            dVar.blC.setText(bVar.Vb.Vj);
        }
        return view;
    }
}
